package com.kyu.chapter05.chapter0503;

import io.reactivex.Observable;

public class Quiz {
    public static void main(String[] args) {
        /*
            1. ranage, filter, map을 이용하여 1부터 15까지의 숫자 중에 2의 배수만 필터링 한 후
               필터링된 숫자에 제곱한 숫자를 출력하세요
         */
        Observable.range(1, 15)
                .filter(num -> num % 2 == 0)
                .map(num -> Math.pow(num, 2))
                .subscribe(num -> System.out.println("제곱 값 : " + num));


        /*
            2. ranage, filter, flatMap을 이용하여 2에서 9까지의 구구단 중에서 짝수단만 출력하세요.
         */
        Observable.range(2, 8)
                .filter(num -> num % 2 == 0)
                .flatMap(
                        num -> Observable.range(1,9)
                                .map(col -> num + " * " + col + " = " + (num * col)))
                .subscribe(result -> System.out.println(result));

    }
}
