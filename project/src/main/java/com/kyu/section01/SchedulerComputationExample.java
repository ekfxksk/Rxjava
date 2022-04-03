package com.kyu.section01;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.Arrays;
import java.util.Collections;

public class SchedulerComputationExample {
    public static void main(String[] args) {

        Observable<Integer> observable1 = Observable.just(1,2,3,4,5);
        Observable<Integer> observable2 = Observable.just(2,4,6,7,0);
        Observable<Integer> observable3 = Observable.just(1,3,5,7,9);

        Observable<Integer> observable4 = Observable.range(1,5);

        Observable source = Observable.zip(observable1, observable2, observable3, observable4,
                (data1, data2, data3, index) -> index + "-> " + Collections.max(Arrays.asList(data1,data2,data3))
        );

        source.subscribeOn(Schedulers.computation())
                .subscribe(data -> System.out.println("On Next(" + Thread.currentThread().getName() + ") -> " + data));

        source.subscribeOn(Schedulers.computation())
                .subscribe(data -> System.out.println("On Next(" + Thread.currentThread().getName() + ") -> " + data));

        try {
            Thread.sleep(300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
