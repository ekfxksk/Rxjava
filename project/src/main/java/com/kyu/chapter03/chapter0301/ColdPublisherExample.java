package com.kyu.chapter03.chapter0301;

import io.reactivex.Flowable;

public class ColdPublisherExample {
    // 대부분 Flowable, Observable 여기에 해당한다.
    public static void main(String[] args) {

        Flowable<Integer> flowable = Flowable.just(1, 3, 5, 7);

        flowable.subscribe(number -> System.out.println("구독자 1 : " + number));
        flowable.subscribe(number -> System.out.println("구독자 2 : " + number));
    }

}
