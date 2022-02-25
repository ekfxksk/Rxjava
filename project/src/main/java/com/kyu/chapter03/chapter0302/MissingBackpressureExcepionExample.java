package com.kyu.chapter03.chapter0302;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class MissingBackpressureExcepionExample {
    public static void main(String[] args) throws InterruptedException {

        Logger logger = Logger.getLogger("test");

        Flowable.interval(1L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> System.out.println("doOnNext : " + data))
                .observeOn(Schedulers.computation())
                .subscribe(
                        data -> {
                            System.out.println("# 소비자 처리 대기 중 .." );
                            Thread.sleep(1000L);
                            System.out.println("subscribe : " + data );
                        },
                        error -> {
                            System.out.println("Error : " + error);
                        },
                        () -> System.out.println("종료")
                );
        Thread.sleep(2000L);
    }

}
