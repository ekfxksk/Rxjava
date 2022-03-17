package com.kyu.chapter05.chapter0506;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableOnErrorReturnExample {
    public static void main(String[] args) {

        Observable.just(5)
                .flatMap(
                        num -> Observable.interval(200L, TimeUnit.MILLISECONDS)
                                .doOnNext(data -> System.out.println("Do On next" + data))
                                .take(5)
                                .map(i -> num / i)
                                .onErrorReturn(exception -> {
                                    System.out.println("에러가 발생했습니다  -> " + exception );

                                    return -1L;
                                })
                )
                .subscribe(
                        data ->{
                            if(data > 0) {
                                System.out.println("On Next : " + data);
                            } else {
                                System.out.println("[Error]On Next : " + data);
                            }
                        },
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
