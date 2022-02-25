package com.kyu.chapter03.chapter0302;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;
/*
    [BUFFER 전략 : DROP_LATEST 예제]
        버퍼가 가득 찬 시점에 버퍼내에서 가장 최근에 버퍼에 들어온 데이터를 Drop 한다.
        Drop 된 빈 자리에 버퍼 밖에서 대기하던 데이터를 채운다.
 */
public class BackpressureBufferExample01 {
    public static void main(String[] args) throws InterruptedException {
        Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> System.out.println("#inveral doOnNext() : " + data))
                .onBackpressureBuffer(
                        2,
                        () -> System.out.println("overflow!"),
                        BackpressureOverflowStrategy.DROP_LATEST
                )
                .doOnNext(data -> System.out.println("#onBackpressureBuffer doOnNext() : " + data ))
                .observeOn(Schedulers.computation(), false, 1)
                .subscribe(
                        data -> {
                            Thread.sleep(1000L);
                            System.out.println("#On Next : " + data);
                        },
                        error -> System.out.println("#On Error : " + error)
                );

        Thread.sleep(3000L);
    }
}
