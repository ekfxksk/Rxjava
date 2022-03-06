package com.kyu.chapter05.chapter0502;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class ObservableFilterExample01 {
    public static void main(String[] args) {

        Observable.range(0,5)
                .filter(number -> number % 2 == 0)
                .filter(number -> number > 0)
                .subscribe(data -> System.out.println("On Next : " + data));
    }
}
