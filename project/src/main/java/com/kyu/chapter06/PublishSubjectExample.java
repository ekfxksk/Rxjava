package com.kyu.chapter06;

import io.reactivex.subjects.PublishSubject;

public class PublishSubjectExample {
    public static void main(String[] args) {
        PublishSubject subject = PublishSubject.create();
        subject.subscribe(price -> System.out.println("On Next -> 소비자 1 : " + price));
        subject.onNext(3500);
        subject.subscribe(price -> System.out.println("On Next -> 소비자 2 : " + price));
        subject.onNext(3400);
        subject.subscribe(price -> System.out.println("On Next -> 소비자 3 : " + price));
        subject.onNext(3300);

        subject.subscribe(
                price -> System.out.println("On Next -> 소비자 4 : " + price),
                error -> System.out.println("On Error -> " + error),
                () -> System.out.println("On Complete")
        );

        subject.onComplete();
    }
}
