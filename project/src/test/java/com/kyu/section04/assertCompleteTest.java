package com.kyu.section04;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class assertCompleteTest {

    @Test
    public void assertComplateTest() {
        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .take(5)
                .test()
                .awaitDone(1000L, TimeUnit.MILLISECONDS)
                .assertComplete();
    }
}
