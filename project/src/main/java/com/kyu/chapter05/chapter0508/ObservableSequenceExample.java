package com.kyu.chapter05.chapter0508;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ObservableSequenceExample {
    public static void main(String[] args) {
        Observable<Integer> observable1 = Observable.just(1, 2, 3, 4, 5)
                .subscribeOn(Schedulers.io())
                .delay(data -> {
                    Thread.sleep(200L);

                    return Observable.just(data);
                })
                .doOnNext(data -> System.out.println("observable1 Do on Next -> " + data));

        Observable<Integer> observable2 = Observable.just(1, 2, 3, 4, 5)
                .subscribeOn(Schedulers.io())
                .delay(data -> {
                    Thread.sleep(300L);

                    return Observable.just(data);
                })
                .doOnNext(data -> System.out.println("observable2 Do on Next -> " + data));


        Observable.sequenceEqual(observable1, observable2)
                        .subscribe(data -> System.out.println("On next -> " + data));

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
