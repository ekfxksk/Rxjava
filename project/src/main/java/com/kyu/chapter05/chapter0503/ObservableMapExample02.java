package com.kyu.chapter05.chapter0503;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class ObservableMapExample02 {
    public static void main(String[] args) {
        Observable.just("korea", "canada", "paris", "japan", "china")
                .filter(data -> data.length() == 5)
                .map(data -> data.toUpperCase().charAt(0) + data.substring(1))
                .subscribe(data -> System.out.println("On Next : " + data));
    }

}
