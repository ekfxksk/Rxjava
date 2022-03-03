package com.kyu.chapter05.chapter0501;

import io.reactivex.Observable;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ObservableFromIterableExample {
    public static void main(String[] args) {
        List<String> countries = Arrays.asList("한국", "미국", "일본", "중국");

        Observable<String> observable = Observable.fromIterable(countries);
        observable.subscribe(data -> System.out.println("On Next : " + data));
    }
}
