package com.kyu.section03;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class BlockingForEachTest {
    @Test
    public void test1() {
        Observable.range(1,5)
                .filter(data -> data > 2)
                .blockingForEach(data -> {
                    assertTrue(data > 2);
                });

    }

}
