package com.kyu.chapter06;

import io.reactivex.subjects.AsyncSubject;

public class AsyncSubjectExample {
    public static void main(String[] args) {
        AsyncSubject subject = AsyncSubject.create();
        subject.onNext(1000);

        subject.doOnNext(price -> System.out.println("Do On Next -> 소비자 1 : " + price))
                .subscribe(price -> System.out.println("On Next -> 소비자 1 : " + price));
        subject.onNext(2000);

        subject.doOnNext(price -> System.out.println("Do On Next -> 소비자 2 : " + price))
                .subscribe(price -> System.out.println("On Next -> 소비자 2 : " + price));
        subject.onNext(3000);

        subject.doOnNext(price -> System.out.println("Do On Next -> 소비자 3 : " + price))
                .subscribe(price -> System.out.println("On Next -> 소비자 3 : " + price));
        subject.onNext(4000);

        subject.onComplete();

        subject.doOnNext(price -> System.out.println("Do On Next -> 소비자 4 : " + price))
                .subscribe(price -> System.out.println("On Next -> 소비자 4 : " + price));


    }
}
