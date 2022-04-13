package com.kyu.section04;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class assertNotCompleteTest {

    @Test
    public void assertNotComplateTest() {
        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .take(5)
                .test()
                .awaitDone(300L, TimeUnit.MILLISECONDS)
                .assertNotComplete();
    }
}
