package com.kyu.chapter05.chapter0507;

import io.reactivex.Observable;

import java.util.Random;

public class ObservableTimeIntervalExample01 {
    public static void main(String[] args) {
        Observable.just(1,2,3,4)
                .delay(item -> {
                    Thread.sleep(getRandom(100, 10));

                    return Observable.just(item);
                })
                .timeInterval()
                .subscribe(data -> System.out.println("On Next -> " + data.time() + " / " + data.value()));

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static long getRandom(int i, int i1) {
       Random random = new Random();
       random.setSeed(System.currentTimeMillis());

        return random.nextInt(i1) * i;
    }


}
