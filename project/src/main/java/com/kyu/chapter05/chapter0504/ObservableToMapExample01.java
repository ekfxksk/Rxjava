package com.kyu.chapter05.chapter0504;

import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.Map;

public class ObservableToMapExample01 {

    public static void main(String[] args) {
        Single<Map<String, String>> single = Observable.just("a-a", "b-b", "c-c", "d-d", "e-e")
                                    .toMap(data -> data.split("-")[0]);

        single.subscribe(data -> System.out.println("On Next : " + data));
    }

}
