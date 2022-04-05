package com.kyu.section02;

import io.reactivex.Observable;

public class DoOnCompleteExample {
    public static void main(String[] args) {
        Observable.range(1,5)
                .doOnComplete(() -> System.out.println("Do On Complete -> # 생산자 : 데이터 통지 완료"))
                .subscribe(
                        data -> System.out.println("On Next -> " + data),
                        error -> System.out.println("On Error -> " + error),
                        () -> System.out.println("On Complete")
                );
    }
}
