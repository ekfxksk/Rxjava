package com.kyu.web;

import com.kyu.domain.Weather;
import com.kyu.repository.WeatherRepository;
import com.kyu.sensor.HumiditySensor;
import com.kyu.sensor.TemperatureSensor;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class WeatherController {
    private final HumiditySensor humiditySensor;
    private final TemperatureSensor temperatureSensor;
    private final WeatherRepository weatherRepository;

    final long SSE_SESSION_TIMEOUT = 30 * 60 * 1000L;
    private SseEmitter emitter;
    private List<Disposable> disposables = new ArrayList<>();

    public WeatherController(HumiditySensor humiditySensor,
                             TemperatureSensor temperatureSensor,
                             WeatherRepository weatherRepository) {
        this.humiditySensor = humiditySensor;
        this.temperatureSensor = temperatureSensor;
        this.weatherRepository = weatherRepository;
    }

    @CrossOrigin("*")
    @GetMapping("/stream/weather")
    public SseEmitter connectWeatherEvents() {
        emitter = new SseEmitter(SSE_SESSION_TIMEOUT);

        ConnectableObservable<Weather> connectableObservable =
                Observable.zip(
                        temperatureSensor.getTemperatureStream(),
                        humiditySensor.getHumidityStream(),
                        (temperature, humidity) -> new Weather(temperature, humidity)
                ).publish();

        Disposable disposableSend = sendWeatherData(connectableObservable);
        Disposable disposableSave = saveWeatherData(connectableObservable);

        disposables.add(disposableSave);
        disposables.add(disposableSend);

        connectableObservable.connect();

        this.dispose(emitter, () ->
                disposables.stream()
                        .filter(disposable -> !disposable.isDisposed())
                        //.forEach(Disposable::dispose);
                        .forEach(disposable -> disposable.dispose())
        );

        return emitter;

    }

    private Disposable sendWeatherData(ConnectableObservable<Weather> connectableObservable) {
        return connectableObservable.subscribe(
                weather -> {
                    emitter.send(weather);
                    log.info("On Next -> {} / {} " , weather.getTemperature(), weather.getHumidity());
                },
                error -> log.info("On Error -> {}", error.getMessage())
        );
    }
    private Disposable saveWeatherData(ConnectableObservable<Weather> connectableObservable) {
        return connectableObservable.subscribe(
                weather -> {
                    weatherRepository.save(weather);
                },
                error -> log.info("On Error -> {}", error.getMessage())
        );
    }
    private void dispose(SseEmitter emitter, Runnable runnable) {
        emitter.onCompletion(runnable);
        emitter.onTimeout(runnable);
    }

}
