package com.kyu.section02;

import com.kyu.common.CarMaker;
import com.kyu.common.SampleData;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class DoOnDisposeExample {
    public static void main(String[] args) {
        Observable.fromArray(SampleData.carMakers)
                .zipWith(Observable.interval(300L, TimeUnit.MILLISECONDS), (carMaker, num) -> carMaker)
                .doOnDispose(() -> System.out.println("Do On Dispose -> # 생산자 : 구독 해지 완료"))
                .subscribe(new Observer<CarMaker>() {

                    private Disposable disposable;
                    private long startTime;

                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {
                        this.disposable = disposable;
                        this.startTime = System.currentTimeMillis();
                    }

                    @Override
                    public void onNext(@NonNull CarMaker carMaker) {
                        System.out.println("On Next -> " + carMaker);

                        if(System.currentTimeMillis() - startTime > 1000L ) {
                            System.out.println("# 소비자 : rnehr gowl , 1000L 초과");
                            disposable.dispose();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {
                        System.out.println("On Error -> " + throwable);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("On Complete ");
                    }
                });
        try {
            Thread.sleep(2000L);
        } catch (Exception e) {

        }

    }
}
