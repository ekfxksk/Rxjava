package com.kyu.chapter05.chapter0502;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Quiz {
    public static void main(String[] args) {
        // 1. interval, takeWhile을 이용하여 발생된 숫자가 10이 아닌동안 데이터를 1초에 한번씩 계속 출력하세요.

        Observable.interval(1000L, TimeUnit.MILLISECONDS)
                .takeWhile(number -> number != 10)
                .subscribe(data -> System.out.println("#1 On Next : " + data));


        // 2. interval, skipUntil, timer를 이용하여 1초에 한번씩 발행된 데이터 중에서 3초 후에 발생된 데이터만 10까지 출력하시오.
        Observable.interval(1000L, TimeUnit.MILLISECONDS)
                .skipUntil(Observable.timer(3000L, TimeUnit.MILLISECONDS))
                .subscribe(data -> System.out.println("#2 On Next : " + data));

        // 3. range.skipLast를 이용하여 1부터 15까지 숫자중에서 마지막에 발생횐 숫자 3개를 제외한 나머지 숫자를 출력하세요.
        Observable.range(1,15)
                .skipLast(3)
                .subscribe(data -> System.out.println("#3 On Next : " + data));


        try {
            Thread.sleep(11500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
