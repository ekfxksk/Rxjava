package com.kyu.section02;

import io.reactivex.Observable;

public class DoOnErrorExample {
    public static void main(String[] args) {
        Observable.just(3,6,9,12,15,20)
                .zipWith(Observable.just(1,2,3,4,0,5), (a,b) -> a / b)
                .doOnError(error -> System.out.println("Do On Complete -> # 생산자 : 에러 발생 : " + error.getMessage()))
                .subscribe(
                        data -> System.out.println("On Next -> " + data),
                        error -> System.out.println("On Error -> " + error)
                );
    }
}
