package com.kyu.chapter05.chapter0503;

import io.reactivex.Observable;

public class ObservableFlatMapExample02 {
    public static void main(String[] args) {
        Observable.range(2, 1)
                .flatMap(num -> Observable.range(1,9).map(row -> num + "*" + row + "=" + num * row))
                .subscribe(data -> System.out.println("On Next : " + data));
    }

}
