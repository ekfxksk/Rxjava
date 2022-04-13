package com.kyu.section04;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class AssertResultTest {

    @Test
    public void assertResultFailTest() {
        Observable.interval(200L, TimeUnit.MILLISECONDS)
                .filter(data -> data > 3)
                .test()
                .awaitDone(1100L, TimeUnit.MILLISECONDS)
                .assertResult(4L);
    }

    @Test
    public void assertResultSuccessTest() {
        Observable.interval(200L, TimeUnit.MILLISECONDS)
                .take(5)
                .filter(data -> data > 3)
                .test()
                .awaitDone(1100L, TimeUnit.MILLISECONDS)
                .assertResult(4L);
    }
}
