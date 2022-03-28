package com.kyu.chapter05.chapter0509;

import io.reactivex.Observable;

public class ObservableCountExample01 {
    public static void main(String[] args) {
        Observable.just(1,2,3,4,5)
                .count()
                .subscribe(data -> System.out.println("On Next -> " + data));

    }
}
