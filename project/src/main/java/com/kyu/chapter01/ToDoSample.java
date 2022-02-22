package com.kyu.chapter01;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class ToDoSample {
    public static void main(String[] args) throws InterruptedException {
        Observable.just(100, 200, 300, 400, 500)
                .filter(number -> number > 300)
                /*
                    데이터가 발행이 될때 실행이 된다.
                        - 데이터가 발행이 될때는 OnNext가 실행이된다.
                        - 이 OnNext가 실행될 때 doOnNext가 실행된다.
                 */
                .doOnNext(data -> System.out.println(getThreadName() + " : # doOnNext : " + data))
                /*
                    메인 스레드가 아닌 다른 스레드에서 실행시킨다.
                        - 데이터의 발행/흐름을 결정 짓는 스레드를 결정
                 */
                .subscribeOn(Schedulers.io())
                /*
                    발행된 데이터를 가공하고 구독해서 처리하는 스레드를 결정
                 */
                .observeOn(Schedulers.computation())
                .subscribe(number -> System.out.println(getThreadName() + " : result : " + number));

        // subscribeOn(Schedulers.io()) 으로 결과를 찍기 전에 종료되어 추가
        Thread.sleep(1000);
    }
    private static String getThreadName() {
        return Thread.currentThread().getName();
    }
}
