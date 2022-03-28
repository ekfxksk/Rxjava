package com.kyu.chapter05.chapter0509;

import io.reactivex.Observable;

import java.util.Arrays;

public class ObservableCountExample02 {
    public static void main(String[] args) {
        Observable.concat(
                Arrays.asList(
                        Observable.just(1,2,3),
                        Observable.just(4,5,6),
                        Observable.just(7,8,9)
                )
        )
        .count()
        .subscribe(data -> System.out.println("On Next -> " + data));

    }
}
