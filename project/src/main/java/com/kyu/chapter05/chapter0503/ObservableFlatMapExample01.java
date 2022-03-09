package com.kyu.chapter05.chapter0503;

import io.reactivex.Observable;

public class ObservableFlatMapExample01 {
    public static void main(String[] args) {
        Observable.just("Hello")
                .flatMap(hello -> Observable.just("자바", "안드로이드", "파이썬").map(lang -> hello + ", " + lang))
                .subscribe(data -> System.out.println("On Next : " + data));
    }

}
