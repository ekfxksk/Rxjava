package com.kyu.chapter05.chapter0509;

import io.reactivex.Observable;

public class ObservableReduceExample02 {
    public static void main(String[] args) {
        Observable.just(1,2,3,4,5)
                .doOnNext(data -> System.out.println("Do On next - > " + data))
                .reduce(5, (x,y) -> {
                    System.out.println("reduce 파라미터 : " + x + "   " + y );
                    return x + y;
                })
                .subscribe(data -> System.out.println("On Next -> " + data));

    }
}
