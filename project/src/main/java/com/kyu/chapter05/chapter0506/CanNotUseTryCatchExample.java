package com.kyu.chapter05.chapter0506;

import io.reactivex.Observable;

public class CanNotUseTryCatchExample {
    public static void main(String[] args) {
        try {
            Observable.just(2)
                    .map(num -> num / 0)
                    .subscribe(System.out::print);
        } catch (Exception e) {
            System.out.println("예외 처리 : " + e);
        }

    }
}
