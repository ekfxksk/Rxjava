package com.kyu.section03;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BlockingSingleTest {
    @Test
    public void test1() {
        assertThrows(IllegalArgumentException.class, () -> {
            Observable.range(1, 5).take(2).blockingSingle();
        });
    }

    @Test
    public void test2() {
        int number = Observable.range(1, 5)
                .filter(data -> data > 3)
                .take(1)
                .blockingSingle();

        assertEquals(number, 4);


    }
}
