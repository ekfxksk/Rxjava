package com.kyu.chapter05.chapter0503;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class ObservableMapExample01 {
    public static void main(String[] args) {
        List<Integer> oddList = Arrays.asList(1, 3, 5, 7, 9);

        Observable.fromIterable(oddList)
                .map(data -> "1을 더해서 출력 : " + (data + 1))
                .subscribe(data -> System.out.println("On Next : " + data));
    }

}
