package com.kyu.chapter05.chapter0502;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class ObservableDistinctExample01 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,1,2,3,4,5);

        Observable.fromIterable(numbers)
                .distinct()
                .subscribe(data -> System.out.println("On Next : " + data));
    }
}
