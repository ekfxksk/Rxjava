package com.kyu.chapter05.chapter0502;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ObservableTakeUntilExample01 {
    public static void main(String[] args) {
        Observable.range(1,5)
                .takeUntil(number -> number == 2)
                .subscribe(data -> System.out.println("On Next : " + data));

    }
}
