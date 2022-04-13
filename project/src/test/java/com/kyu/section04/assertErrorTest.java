package com.kyu.section04;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class assertErrorTest {

    @Test
    public void assertErrorTest() {
        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(data -> {
                    long value;

                    if(data == 4) {
                        value = data / 0;
                    } else {
                        value = data / 2;
                    }
                    return value;
                })
                .test()
                .awaitDone(1000L, TimeUnit.MILLISECONDS)
                .assertError(Throwable.class);

    }
}
