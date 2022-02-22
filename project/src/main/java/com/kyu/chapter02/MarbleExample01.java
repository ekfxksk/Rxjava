package com.kyu.chapter02;

import io.reactivex.Observable;

public class MarbleExample01 {
    public static void main(String[] args) {
        Observable.just(1, 25, 9, 15, 7, 30) // 데이터를 발행하고
                .filter(x -> x > 10)
                .subscribe(x -> System.out.println(x));
    }
}
