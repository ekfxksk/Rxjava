package com.kyu.chapter05.chapter0507;

import io.reactivex.Observable;

public class ObservableDelayExample02 {
    public static void main(String[] args) {
        Observable.just(1,2,3,4)
                .delay(item -> {
                    Thread.sleep(1000L);
                    return Observable.just(item);
                })
                .subscribe(data -> System.out.println("On Next -> " + data));

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
