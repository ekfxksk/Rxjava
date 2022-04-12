package com.kyu.section03;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlockingIterableTest {
    @Test
    public void test1() {
        Iterable<Integer> iterable = Observable.range(1,5).blockingIterable();

        Iterator<Integer> iterator = iterable.iterator();

        assertEquals(iterator.hasNext(), true);
        assertEquals(iterator.next(), 1);
        assertEquals(iterator.next(), 2);
        assertEquals(iterator.next(), 3);
        assertEquals(iterator.next(), 4);
        assertEquals(iterator.next(), 5);


    }

}
