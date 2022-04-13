package com.kyu.section04;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

public class AssertValuesTest {

    @Test
    public void assertValuesTest() {
        Observable.just(2,3)
                .test()
                .assertValues(2,3);
    }
}
