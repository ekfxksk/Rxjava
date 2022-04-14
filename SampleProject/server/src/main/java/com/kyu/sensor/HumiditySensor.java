package com.kyu.sensor;

import com.kyu.utils.NumberUtil;
import io.reactivex.rxjava3.core.Observable;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class HumiditySensor {
    public Observable<Integer> getHumidityStream() {
        return Observable.interval(0L, TimeUnit.MILLISECONDS)
                .delay(item ->{
                    Thread.sleep(NumberUtil.randomRange(1000, 3000));
                    return Observable.just(item);
                })
                .map(notUse -> this.getHumidity());
    }

    private int getHumidity() {
        return NumberUtil.randomRange(30, 70);
    }
}
