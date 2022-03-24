package com.kyu.chapter05.chapter0508;

import io.reactivex.Observable;

public class ObservableContainsExample {
    public static void main(String[] args) {
        Observable.range(1,5)
                .doOnNext(data -> System.out.println("Do on next -> " + data))
                .contains(3)
                .subscribe(data -> System.out.println("On Next -> " + data));
    }
}
