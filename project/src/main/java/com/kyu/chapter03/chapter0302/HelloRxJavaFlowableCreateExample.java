package com.kyu.chapter03.chapter0302;

import io.reactivex.*;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class HelloRxJavaFlowableCreateExample {
    public static void main(String[] args) throws InterruptedException {

        /*
            동작 방식
                1. 소비자에서 구독 (subscribe)
                2. 생상자쪽에서 통지할 준비하 되었음을 알리기 위해 onSubscribe 호출
                3. Subscription 객체를 통해 생산자에게 통지 요청 (this.subscription.request)
                4. subscribe 함수가 호출됨
                5. 생장자에서 onNext 호츨하여 데이터 통지
                6. 소비자에서 통지 받은 데이터를 처리
                7. 생산자에서 데이터 통지가 끝나면 onComplete 호출
         */


        Flowable<String> flowable =
                Flowable.create(new FlowableOnSubscribe<String>() {
                                                                        //2 -1
                    // FlowableEmitter가 데이터를 통지하는 기능을 한다.
                    @Override
                    public void subscribe(@NonNull FlowableEmitter<String> emitter) throws Exception { //4
                        String[] datas = {"Hello", "RxJava!"};

                        for(String data : datas) {
                            // 구독이 해지되면 중단 처리
                            if(emitter.isCancelled()) return;

                            // 데이터 통지 알린다.
                            emitter.onNext(data);       // 5
                        }

                        // 데이터 통지 완료를 알린다.
                        emitter.onComplete();               // 7-1
                    }
                }, BackpressureStrategy.BUFFER); // 구독자의 처리가 늦을 경우 데이터를 버퍼에 담아 두도록 설정

        flowable.observeOn(Schedulers.computation())
                .subscribe(new Subscriber<String>() {   //  1
                    // 데이터 개수 요청 및 구독을 취소하기 위한 Subscription 객체
                    private Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription s) {   // 2-2
                        this.subscription = s;
                        this.subscription.request(Long.MAX_VALUE); // 3
                    }

                    @Override
                    public void onNext(String s) { // 6
                        System.out.println("#onNext ->  " + s);
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("#onError ->  " + t.getMessage());
                    }

                    @Override
                    public void onComplete() {      // 7-2
                        System.out.println("#onComplete");
                    }
                });

        Thread.sleep(500L);

    }
}
