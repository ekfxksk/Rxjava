package com.kyu.chapter05.chapter0506;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableRetryExample01 {
    public static void main(String[] args) {

        Observable.just(5)
                .flatMap(
                        num -> Observable.interval(200L, TimeUnit.MILLISECONDS)
                                .take(5)
                                .map(i -> {
                                        long result;
                                        try {
                                            result = num / i;
                                        } catch (ArithmeticException ex) {
                                            System.out.println("오류 발생 : " + ex.getMessage());
                                            throw ex;
                                        };
                                        return  result;
                                })
                                .retry(3)
                                .onErrorReturn(throwable -> -1L)
                )
                .subscribe(
                        data ->System.out.println("On Next : " + data),
                        error -> System.out.println("On Error : " + error),
                        () -> System.out.println("On Complete")
                );

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
