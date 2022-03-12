package com.kyu.chapter05.chapter0504;

import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

public class ObservableGroupByExample01 {

    public static void main(String[] args) {
        Observable<GroupedObservable<String, Integer>> observable =
                Observable.range(1,10).groupBy(data -> data % 2 == 0 ? "even" : "odd" );

        observable.subscribe(
                stringIntegerGroupedObservable -> stringIntegerGroupedObservable.subscribe(
                    data -> System.out.println("On Next : group-> " + stringIntegerGroupedObservable.getKey() + " / " + data)
                )
        );

    }

}
