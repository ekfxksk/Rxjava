package com.kyu.chapter03.chapter0302;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/*
    [Drop 전략 예제]
        버퍼에 데이터가 모두 채워진 상태가 되면 버퍼가 비워질 때까지 통지된 데이터는 버퍼 밖에서 대기하며,
        버퍼가 비워지는 시점에 가장 나중에(최근에) 통지된 데이터부터 버퍼에 담는다.
 */
public class BackpressureLatestExample {
    public static void main(String[] args) throws InterruptedException {
        Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> System.out.println("#inveral doOnNext() : " + data))
                .onBackpressureLatest()
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
