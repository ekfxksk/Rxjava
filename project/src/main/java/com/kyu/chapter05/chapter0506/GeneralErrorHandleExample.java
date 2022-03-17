package com.kyu.chapter05.chapter0506;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class GeneralErrorHandleExample {
    public static void main(String[] args) {

        Observable.just(5)
                .flatMap(
                        num -> Observable.interval(200L, TimeUnit.MILLISECONDS)
                                .doOnNext(data -> System.out.println("Do On next" + data))
                                .take(5)
                                .map(i -> num / i)
                )
                .subscribe(
                        data -> System.out.println("On Next : " + data),
                        error -> System.out.println("On Error : " + error),
                        () -> System.out.println("On Complete")
                );

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
