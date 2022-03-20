package com.kyu.chapter05.chapter0507;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableTimeoutExample01 {
    public static void main(String[] args) {
        Observable.range(1,9)
                .map(num -> {
                    long time = 1000L;

                    if(num == 4) {
                        time = 1500L;
                    }

                    Thread.sleep(time);
                    return num;
                })
                .timeout(1200L, TimeUnit.MILLISECONDS)
                .subscribe(
                        data -> System.out.println("On Next -> " + data),
                        error -> System.out.println("On Next error -> " + error)
                );
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
