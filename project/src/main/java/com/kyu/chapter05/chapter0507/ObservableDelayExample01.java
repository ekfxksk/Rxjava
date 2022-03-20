package com.kyu.chapter05.chapter0507;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableDelayExample01 {
    public static void main(String[] args) {
        Observable.just(1,2,3,4)
                .doOnNext(data -> System.out.println("doOnNext -> " + data))
                .delay(2000L, TimeUnit.MILLISECONDS)
                .subscribe(data -> System.out.println("On Next -> " + data));

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
