package com.kyu.section02;

import io.reactivex.Observable;

public class DoOnEachExample {
    public static void main(String[] args) {
        Observable.range(1,5)
                .doOnEach(integerNotification -> {
                    if(integerNotification.isOnNext()) {
                        System.out.println("Do On Next -> # 생산자: 데이터 통지 >>  " + integerNotification.getValue());
                    }

                    if(integerNotification.isOnError()) {
                        System.out.println("Do On Next -> # 생산자: 에러 발생 >>  " + integerNotification.getError());
                    }

                    if(integerNotification.isOnComplete()) {
                        System.out.println("Do On Next -> # 생산자: 데이터 통지 완료");
                    }

                })
                .subscribe(
                        data -> System.out.println("On Next -> " + data),
                        error -> System.out.println("On Error -> " + error),
                        () -> System.out.println("On Complete")
                );
    }

}
