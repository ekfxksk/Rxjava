package com.kyu.section01;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.io.File;

public class SchedulerIOExample03 {
    public static void main(String[] args) {
        File[] files = new File("src/main/java/com/kyu/").listFiles();

        // observeOn()을 여러개 지정하면 지정한 다음의 데이터 처리를 각각 개벌 스레드에서 진행한다.
        Observable.fromArray(files)
                .doOnNext(data -> System.out.println("Do On Next(" + Thread.currentThread().getName() + ") -> 데이터 통지"))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .filter(data -> data.isDirectory())
                .doOnNext(data -> System.out.println("Do On Next(" + Thread.currentThread().getName() + ") -> Filter 처리"))
                .observeOn(Schedulers.computation())
                .map(dir -> dir.getName())
                .doOnNext(data -> System.out.println("Do On Next(" + Thread.currentThread().getName() + ") -> map 처리"))
                .observeOn(Schedulers.computation())
                .subscribe(data -> System.out.println("On Next(" + Thread.currentThread().getName() + ") -> " + data));

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
