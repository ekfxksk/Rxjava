package com.kyu.chapter05.chapter0508;

import io.reactivex.Observable;

public class ObservableAllExample {
    public static void main(String[] args) {
        Observable.range(1,10)
                .doOnNext(data -> System.out.println("Do On Next -> " + data))
                .all(num -> num < 5)
                .subscribe(data -> System.out.println("On Next : " + data));
    }

}
