package com.kyu.section03;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlockingGetTest {
    @Test
    public void test1() {
        assertEquals(Observable.empty().firstElement().blockingGet(), null);
    }

    @Test
    public void test2() {
        int total = Observable.range(1,5)
                .reduce((a,b) -> a + b)
                .blockingGet();


        assertEquals(total,  15);


    }
}
