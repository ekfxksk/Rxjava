package com.kyu.chapter03.chapter0301;

import io.reactivex.processors.PublishProcessor;
import io.reactivex.subjects.PublishSubject;

public class HotPublisherExample {
    // Processor , Subject 끝나는 것이 여기에 해당된다고 볼 수 있다.
    public static void main(String[] args) {
        PublishProcessor<Integer> processor = PublishProcessor.create();
        processor.subscribe(data -> System.out.println("구독자 1 : " + data));
        processor.onNext(1);
        processor.onNext(3);
        processor.subscribe(data -> System.out.println("구독자 2 : " + data));
        processor.onNext(5);
        processor.onNext(7);

        processor.onComplete();
    }
}
