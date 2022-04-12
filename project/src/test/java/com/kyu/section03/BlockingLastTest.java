package com.kyu.section03;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlockingLastTest {
    @Test
    public void test1() {
        int number = Observable.range(1, 5).blockingLast();

        assertEquals(number, 5);

    }
}
