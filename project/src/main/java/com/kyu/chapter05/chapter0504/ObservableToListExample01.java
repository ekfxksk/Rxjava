package com.kyu.chapter05.chapter0504;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.observables.GroupedObservable;

import java.util.List;

public class ObservableToListExample01 {

    public static void main(String[] args) {
        Single<List<Integer>> single = Observable.just(1,2,3,4,5)
                                    .toList();

        single.subscribe(data -> System.out.println("On Next : " + data));
    }

}
