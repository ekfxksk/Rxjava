package com.kyu.chapter03.chapter0303;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class SingleCreateExample {
    public static void main(String[] args) {
        Single<String> single = Single.create(new SingleOnSubscribe<String>() {

            @Override
            public void subscribe(@NonNull SingleEmitter<String> emitter) throws Exception {
                emitter.onSuccess("Hello RxJava");
            }
        });

        single.subscribe(new SingleObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                // 아무것도 하지 않음
            }

            @Override
            public void onSuccess(@NonNull String s) {
                System.out.println("onSuccess -> " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError -> " + e.getMessage());
            }
        });

    }
}
