package com.kyu.section03;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BlockingSubscribeTest {
    @Test
    public void test1() {
        Calculator calculator = new Calculator();

        Observable.range(1,5)
                .blockingSubscribe(data -> calculator.sumTotal(data));

        assertEquals(calculator.getTotalInt(), 15);
    }
}

