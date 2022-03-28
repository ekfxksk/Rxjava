package com.kyu.chapter05.chapter0509;

import io.reactivex.Observable;

public class Quiz {
    public static void main(String[] args) {
        Observable.range(1, 9)
                .doOnNext(data -> System.out.println("Do On next -> " + data))
                .reduce(10, (x,y) -> x - y)
                .subscribe(data -> System.out.println("On Next -> " + data));
    }
}
