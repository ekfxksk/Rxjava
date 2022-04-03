package com.kyu.chapter06;

import io.reactivex.subjects.ReplaySubject;

public class ReplaySubjectExample01 {
    public static void main(String[] args) {
        ReplaySubject subject = ReplaySubject.create();
        subject.onNext(1000);
        subject.onNext(2000);


        subject.subscribe(price -> System.out.println("On Next -> 소비자 1 : " + price));
        subject.onNext(3000);

        subject.subscribe(price -> System.out.println("On Next -> 소비자 2 : " + price));
        subject.onNext(4000);

        subject.onComplete();

        subject.subscribe(price -> System.out.println("On Next -> 소비자 3 : " + price));



    }
}
