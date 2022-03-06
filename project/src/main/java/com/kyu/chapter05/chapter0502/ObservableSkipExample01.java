package com.kyu.chapter05.chapter0502;

import io.reactivex.Observable;

public class ObservableSkipExample01 {
    public static void main(String[] args) {
        Observable.range(1,5)
                .skip(2)
                .subscribe(data -> System.out.println("On Next : " + data));

    }
}
