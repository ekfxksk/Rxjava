package com.kyu.section01;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class SchedulerTrampolineExample {
    public static void main(String[] args) {
        Observable<String> observable = Observable.just("1", "2", "3", "4", "5");

        observable.subscribeOn(Schedulers.trampoline())
                .map(data -> "## " + data + " ##")
                .subscribe(data -> System.out.println("On Next(" + Thread.currentThread().getName() + ") -> " + data));

        observable.subscribeOn(Schedulers.trampoline())
                .map(data -> "$$ " + data + " $$")
                .subscribe(data -> System.out.println("On Next(" + Thread.currentThread().getName() + ") -> " + data));


        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
