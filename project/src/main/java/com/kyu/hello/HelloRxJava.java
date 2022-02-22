package com.kyu.hello;

import io.reactivex.Observable;
import org.reactivestreams.Subscriber;

public class HelloRxJava {
    public static void main(String[] args) {
        // 데이터 생성 및 통지(알림)
       Observable<String> observable = Observable.just("Hello", "RxJava");
        //데이터를 구독하여 출력한다.
        observable.subscribe(data -> System.out.println(data));
    }
}
