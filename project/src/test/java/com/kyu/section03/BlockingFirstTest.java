package com.kyu.section03;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlockingFirstTest {
    @Test
    public void test1() {
        int number = Observable.range(1, 5).blockingFirst();

        assertEquals(number, 1);

    }
}
