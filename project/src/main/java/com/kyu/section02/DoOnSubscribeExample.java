package com.kyu.section02;

import io.reactivex.Observable;

public class DoOnSubscribeExample {
    public static void main(String[] args) {
        Observable.just(1,2,3,4,5,6,7)
                .doOnSubscribe(disposable -> System.out.println("Do On Subscribe -> 생산자 : 구독 처리 준비 완료" ))
                .subscribe(
                        data -> System.out.println("On Next -> " + data),
                        error -> System.out.println("On Error -> " + error),
                        () -> System.out.println("On Complete"),
                        dispose -> System.out.println("On Subscribe -> 소비자 구독 처리 준비 완료 알림 받음" )
                );
    }
}
