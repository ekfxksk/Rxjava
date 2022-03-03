package com.kyu.chapter05.chapter0501;

import io.reactivex.Completable;
import io.reactivex.Observable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class ObservableFromFutureExample {
    public static void main(String[] args) {
        Future<Double> future = longTimeWork();

        shortTimeWork();

        Observable.fromFuture(future)
                .subscribe(data -> System.out.println("#긴 처리 시간 작업 결과 : " + data));

    }

    private static void shortTimeWork(){
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("#짧은 처리 시간 작업 완료!");
    }

    private static CompletableFuture<Double> longTimeWork() {
        return CompletableFuture.supplyAsync(() -> calculote());
    }

    private static Double calculote() {
        System.out.println("#긴 처리 시간 작업 중 ----------------------------");
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1000000000000000.0;
    }


}
