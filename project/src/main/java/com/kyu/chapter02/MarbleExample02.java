package com.kyu.chapter02;

import io.reactivex.Observable;

public class MarbleExample02 {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.just(2, 25, 30, 15, 6);

        observable.subscribe(number -> System.out.println(number));
    }
}
