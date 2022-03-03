package com.kyu.chapter05.chapter0501;

import io.reactivex.Observable;

import java.time.LocalTime;

public class ObserbableDeferExample {
    public static void main(String[] args) throws InterruptedException {
        Observable<LocalTime> observableDefer = Observable.defer(()-> {
            LocalTime currentTime = LocalTime.now();

            return Observable.just(currentTime);
        });

        Observable<LocalTime> observableJust = Observable.just(LocalTime.now());

        observableDefer.subscribe(data -> System.out.println("# Defer 구독 1 : " + data));
        observableJust.subscribe(data -> System.out.println("# Just 구독 1 : " + data));

        Thread.sleep(3000);

        observableDefer.subscribe(data -> System.out.println("# Defer 구독 2 : " + data));
        observableJust.subscribe(data -> System.out.println("# Just 구독 2 : " + data));
    }
}
