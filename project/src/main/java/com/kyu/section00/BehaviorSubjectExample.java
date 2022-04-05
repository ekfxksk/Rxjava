package com.kyu.section00;

import io.reactivex.subjects.BehaviorSubject;

public class BehaviorSubjectExample {

    public static void main(String[] args) {
        BehaviorSubject subject = BehaviorSubject.createDefault(3000);

        subject.subscribe(price -> System.out.println("On Next -> 소비자 1 : " + price));
        subject.onNext(3500);
        subject.subscribe(price -> System.out.println("On Next -> 소비자 2 : " + price));
        subject.onNext(3400);
        subject.subscribe(price -> System.out.println("On Next -> 소비자 3 : " + price));
        subject.onNext(3300);
    }
}
