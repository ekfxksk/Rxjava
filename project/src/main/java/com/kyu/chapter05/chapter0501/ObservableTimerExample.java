package com.kyu.chapter05.chapter0501;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableTimerExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");
        Observable<String> observable = Observable.timer(5000, TimeUnit.MILLISECONDS)
                .map(count -> "do Work!");

        observable.subscribe(data -> System.out.println("ON Next : " + data));

        Thread.sleep(6000L);
    }
}
