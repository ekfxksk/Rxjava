package com.kyu.chapter05.chapter0508;

import io.reactivex.Observable;

public class ObserverableDefaultIfEmptyExample {
    public static void main(String[] args) {
        Observable.just(1,2,3,4,5)
                .filter(data -> data > 6)
                .defaultIfEmpty(10)
                .subscribe(data -> System.out.println("On Next -> " + data));
    }
}
