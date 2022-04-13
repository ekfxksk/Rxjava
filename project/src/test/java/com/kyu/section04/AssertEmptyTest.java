package com.kyu.section04;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class AssertEmptyTest {

    @Test
    public void failTest() {
        Observable<Integer> observable = Observable.range(1,5);
        TestObserver<Integer> observer = observable.test();
        observer.awaitDone(100L, TimeUnit.MICROSECONDS).assertEmpty();
    }

    @Test
    public void succesTest() {
        Observable<Integer> observable = Observable.range(1,5);
        TestObserver<Integer> observer = observable.delay(1000L, TimeUnit.MICROSECONDS).test();
        observer.awaitDone(100L, TimeUnit.MICROSECONDS).assertEmpty();
    }
}
