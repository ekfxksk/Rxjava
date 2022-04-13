package com.kyu.section04;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class AwaitDoneTest {

    @Test
    public void awaitDoneTest() {
        Observable.interval(200L, TimeUnit.MILLISECONDS)
                .take(5)
                .test()
                .awaitDone(500L, TimeUnit.MILLISECONDS)
                .assertNotComplete()
                .assertValueCount(2);

    }
}
