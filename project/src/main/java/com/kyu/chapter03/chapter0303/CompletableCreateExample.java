package com.kyu.chapter03.chapter0303;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class CompletableCreateExample {
    public static void main(String[] args) {
        Completable  completable = Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(@NonNull CompletableEmitter emitter) throws Exception {
                int sum = 0;
                for(int i = 0; i < 100; i++) {
                    sum += i;
                }

                System.out.println("#합계 : " + sum);

                emitter.onComplete();
            }
        });

        completable.subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                // 아무것도 하지 않음
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError ->" + e.getMessage() );
            }
        });
    }
}
