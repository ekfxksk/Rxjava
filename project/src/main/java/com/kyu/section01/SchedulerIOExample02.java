package com.kyu.section01;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.io.File;

public class SchedulerIOExample02 {
    public static void main(String[] args) {
        File[] files = new File("src/main/java/com/kyu/").listFiles();

        Observable.fromArray(files)
                .doOnNext(data -> System.out.println("Do On Next(" + Thread.currentThread().getName() + ") -> " + data.getName()))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .filter(data -> data.isDirectory())
                .map(dir -> dir.getName())
                .subscribe(data -> System.out.println("On Next(" + Thread.currentThread().getName() + ") -> " + data));

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
