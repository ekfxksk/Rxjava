package com.kyu.chapter05.chapter0505;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableConcatExample01 {
    public static void main(String[] args) {

        Observable<Long> observable1 = Observable.interval(500L, TimeUnit.MILLISECONDS)
                                                .take(4);

        Observable<Long> observable2 = Observable.interval(300L, TimeUnit.MILLISECONDS )
                                                .take(5)
                                                .map(data -> data + 1000);

        Observable.concat(observable1, observable2)
                .subscribe(data -> System.out.println("On Next : " + data));

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
