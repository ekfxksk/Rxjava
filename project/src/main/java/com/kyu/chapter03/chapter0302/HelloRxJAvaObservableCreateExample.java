package com.kyu.chapter03.chapter0302;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HelloRxJAvaObservableCreateExample {
    public static void main(String[] args) throws InterruptedException {

        /*
            1. 소비자에서 구독 (subscribe)
            2. 생상자쪽에서 통지할 준비하 되었음을 알리기 위해 onSubscribe 호출
            3. subscribe 함수가 호출됨
            4. 생장자에서 onNext 호츨하여 데이터 통지
            5. 소비자에서 통지 받은 데이터를 처리
            6. 생산자에서 데이터 통지가 끝나면 onComplete 호출
         */

        Observable<String> observable =
                Observable.create(new ObservableOnSubscribe<String>() {
                                                                            // 2-1
                    // ObservableEmitter 에서 데이터를 통지
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception { //  3
                        String[] datas = {"Hello", "RxJava!"};

                        for(String data : datas) {
                            // 구독이 해지되면 중단 처리
                            if(emitter.isDisposed()) return;

                            // 데이터 통지 알린다.
                            emitter.onNext(data);    // 4
                        }

                        // 데이터 통지 완료를 알린다.
                        emitter.onComplete();   // 6-1
                    }
                });

        observable.observeOn(Schedulers.computation())
                // Observer 객체가 구독과 처리
                .subscribe(new Observer<String>() {     // 1

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {  // 2-2
                        // 아무것도 처리 하지 않음
                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        System.out.println("#onNext ->  " + s); // 5
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println("#onError ->  " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("#onComplete");      // 6-2
                    }
                });

        Thread.sleep(500L);
    }
}
