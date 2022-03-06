package com.kyu.chapter05.chapter0502;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableTakeExample02 {
    public static void main(String[] args) {

        Observable.interval(300L, TimeUnit.MILLISECONDS)
                .take(1000L, TimeUnit.MILLISECONDS)
                .subscribe(data -> System.out.println("On Next : " + data));

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
