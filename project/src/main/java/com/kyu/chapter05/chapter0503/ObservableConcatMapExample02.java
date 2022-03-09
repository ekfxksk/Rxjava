package com.kyu.chapter05.chapter0503;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableConcatMapExample02 {
    public static void main(String[] args) {
        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .take(4)
                .skip(2)
                .concatMap(
                        num -> Observable.interval(200L, TimeUnit.MILLISECONDS)
                                .take(10)
                                .skip(1)
                                .map(row -> num + "*" + row + "=" + num * row)
                )
                .subscribe(
                        data -> System.out.println("On Next : " + data),
                        error -> {},
                        () -> {
                            System.out.println("종료");
                        }
                );

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
