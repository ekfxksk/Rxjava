package com.kyu.chapter05.chapter0507;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.Arrays;

public class ObservableMaterializeExample02 {
    public static void main(String[] args) {
        Observable.concatEager(
                Observable.just(
                        getDBUser().subscribeOn(Schedulers.io()),
                        getAPIUser()
                                .subscribeOn(Schedulers.io())
                                .materialize()
                                .map(data -> {
                                    if(data.isOnError()) {
                                        System.out.println(" API User 오류 발생");
                                    }

                                    return data;
                                })
                                .filter(data -> !data.isOnError())
                                .dematerialize(data -> data)
                )
        ).subscribe(
                data -> System.out.println("On Next -> " + data),
                error -> System.out.println("On Next error -> " + error),
                () -> System.out.println("On complate ")
        );

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Observable<String> getAPIUser() {
        return Observable.just("API User1", "API User2", "Not User", "API User4","API User5")
                .map(user -> {
                    if("Not User".equals(user)) {
                        throw new RuntimeException();
                    }

                    return user;
                });
    }

    private static Observable<String> getDBUser() {
        return Observable.fromIterable(Arrays.asList("DB User1", "DB User2", "DB User3", "DB User4", "DB User5"));
    }
}
