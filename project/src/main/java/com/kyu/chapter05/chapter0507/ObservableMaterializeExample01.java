package com.kyu.chapter05.chapter0507;

import io.reactivex.Observable;

public class ObservableMaterializeExample01 {
    public static void main(String[] args) {
        Observable.just(1,2,3,4)
                .materialize()
                .subscribe(data -> {
                    System.out.println("Notfification 타입 -> " + (data.isOnNext() ? "On Next" : data.isOnError() ? "On Error" : "OnComplete()"));
                    System.out.println(data.getValue());
                });

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
