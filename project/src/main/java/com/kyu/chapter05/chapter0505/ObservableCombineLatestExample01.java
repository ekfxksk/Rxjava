package com.kyu.chapter05.chapter0505;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableCombineLatestExample01 {
    public static void main(String[] args) {
        
        Observable<Long> observable1 = Observable.interval(500L, TimeUnit.MILLISECONDS)
                                                .take(4);

        Observable<Long> observable2 = Observable.interval(700L, TimeUnit.MILLISECONDS )
                                                .take(4);

        Observable.combineLatest(observable1, observable2, (data1, data2) -> "data1 -> " + data1 + "\tdata2 -> " + data2)
                .subscribe(data -> System.out.println("On Next : " + data));

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
