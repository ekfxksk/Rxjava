package com.kyu.section04;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

public class AssertValueTest {

    @Test
    public void assertValueTest() {
        Observable.just(2)
                .test()
                .assertValue(2);
    }
}
