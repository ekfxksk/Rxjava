package com.kyu.section02;

import io.reactivex.Observable;

public class DoOnNextExample {
    public static void main(String[] args) {
        Observable.just(1,3,5,7,9,10,11,12,13)
                .doOnNext(data -> System.out.println("Do On Next -> #원본 데이터 : " + data))
                .filter(data -> data < 10)
                .doOnNext(data -> System.out.println("Do On Next -> #Filter 후 : " + data))
                .map(data -> "#### " + data + " ###")
                .doOnNext(data -> System.out.println("Do On Next -> #Map 후 : " + data))
                .subscribe(data -> System.out.println("On Next -> #최종 데이터 : " + data));
    }
}
