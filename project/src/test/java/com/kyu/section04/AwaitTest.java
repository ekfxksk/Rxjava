package com.kyu.section04;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AwaitTest {

    @Test
    public void awaitTest1() throws InterruptedException {
        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .take(5)
                .test()
                .await()
                .assertComplete()
                .assertValueCount(5);

    }

    @Test
    public void awaitTest2() throws InterruptedException {
        boolean result = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .take(5)
                .test()
                .await(2000L, TimeUnit.MILLISECONDS);

        assertEquals(result, true);
    }

}
