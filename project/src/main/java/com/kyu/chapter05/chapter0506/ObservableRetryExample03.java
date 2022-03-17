package com.kyu.chapter05.chapter0506;

import io.reactivex.Observable;

public class ObservableRetryExample03 {
    public static void main(String[] args) {

        Observable.just(10,12,15,16)
                .zipWith(Observable.just(1,2,0,4), (a,b) -> {
                        long result;
                        try {
                            result = a / b;
                        } catch (ArithmeticException ex) {
                            System.out.println("오류 발생 : " + ex.getMessage());
                            throw ex;
                        };
                        return  result;
                })
                .retry(3)
                .onErrorReturn(throwable -> -1L)
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
