package com.kyu.chapter05.chapter0501;

import io.reactivex.Observable;

public class ObservableRangeExample {
    public static void main(String[] args) {
     //   Observable<Integer> source = Observable.range(0, 5);
     //   source.subscribe(num -> System.out.println("On Next : " + num));

        Observable.range(0,5)
                .subscribe(num -> System.out.println("On Next : " + num));
    }
}
