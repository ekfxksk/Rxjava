package com.kyu.chapter05.chapter0501;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableIntervalExample {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(0L, 1000L,  TimeUnit.MILLISECONDS)
                .map(num -> num + "count" )
                .subscribe(data -> System.out.println("On Next : " + data));

        Thread.sleep(3000L);
    }
}
