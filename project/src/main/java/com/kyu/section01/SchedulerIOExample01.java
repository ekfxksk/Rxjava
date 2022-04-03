package com.kyu.section01;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.io.File;

public class SchedulerIOExample01 {
    public static void main(String[] args) {
        File[] files = new File("src/main/java/com/kyu/").listFiles();

        Observable.fromArray(files)
                .doOnNext(data -> System.out.println("Do On Next (" + Thread.currentThread().getName() + ") -> " + data.getName()))
                .filter(data -> data.isDirectory())
                .map(dir -> dir.getName())
                .subscribeOn(Schedulers.io())
                .subscribe(data -> System.out.println("On Next (" + Thread.currentThread().getName() + ") -> " + data));

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
