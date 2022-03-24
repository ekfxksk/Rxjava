package com.kyu.chapter05.chapter0508;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ObservableAmbExample {
    public static void main(String[] args) {
        List<Observable<Integer>> observables = Arrays.asList(
                Observable.just(1,2,3,4,5)
                        .delay(200L, TimeUnit.MILLISECONDS)
                        .doOnComplete(() -> System.out.println("Dd On Complate 1")),
                Observable.just(7,8,9)
                        .delay(400L, TimeUnit.MILLISECONDS)
                        .doOnComplete(() -> System.out.println("Dd On Complate 2")),
                Observable.just(55, 66, 77, 98)
                        .delay(80L, TimeUnit.MILLISECONDS)
                        .doOnComplete(() -> System.out.println("Dd On Complate 3"))
        );

        Observable.amb(observables)
                .doOnComplete(() -> System.out.println("Do on Complate : 완료"))
                .subscribe(data -> System.out.println("On Next : " + data));
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
