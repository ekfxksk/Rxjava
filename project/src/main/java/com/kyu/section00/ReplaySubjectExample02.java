package com.kyu.section00;

import io.reactivex.subjects.ReplaySubject;

public class ReplaySubjectExample02 {
    public static void main(String[] args) {
        ReplaySubject subject = ReplaySubject.createWithSize(2);
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
