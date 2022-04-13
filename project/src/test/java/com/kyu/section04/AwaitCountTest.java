package com.kyu.section04;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class AwaitCountTest {

    @Test
    public void awaitCountTest() throws InterruptedException {
        Observable.interval(200L, TimeUnit.MILLISECONDS)
                .take(5)
                .test()
                .awaitCount(5)
                .assertComplete()
                .assertValueCount(5)
                .assertValues(0L, 1L, 2L, 3L, 4L);

    }


}
