package com.kyu.chapter05.chapter0502;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableSkipExample02 {
    public static void main(String[] args) {
        Observable.interval(1000L, TimeUnit.MILLISECONDS)
                .skip(3500L, TimeUnit.MILLISECONDS)
                .subscribe(data -> System.out.println("On Next : " + data));


        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
