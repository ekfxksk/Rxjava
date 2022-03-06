package com.kyu.chapter05.chapter0502;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class ObservableTakeExample01 {
    public static void main(String[] args) {

        Observable.just("a", "b", "c", "d")
                .take(3)
                .subscribe(data -> System.out.println("On Next : " + data));
    }
}
