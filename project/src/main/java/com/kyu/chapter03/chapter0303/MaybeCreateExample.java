package com.kyu.chapter03.chapter0303;

import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MaybeCreateExample {
    public static void main(String[] args) {
        Maybe<String> maybe = Maybe.create(new MaybeOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull MaybeEmitter<String> emitter) throws Exception {
                emitter.onSuccess("Hello RxJava");
                //emitter.onComplete();
            }
        });

        maybe.subscribe(new MaybeObserver<String>() {
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

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }
}
