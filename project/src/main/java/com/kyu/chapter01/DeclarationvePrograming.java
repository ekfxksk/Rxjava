package com.kyu.chapter01;

import java.util.Arrays;
import java.util.List;

public class DeclarationvePrograming {
    public static void main(String[] args) {
        // List에 있는 숫자들 주에서 6보다 큰 홀수들의 합계를 구하시오
        List<Integer> numbers = Arrays.asList(1, 3, 21, 10, 8, 11);

        int sum = numbers.stream()
                .filter(number -> number > 6 && (number % 2 != 0))
                .mapToInt(x -> x)
                .sum();

        System.out.println("# 선언형 프로그래밍 사용 : " + sum);
    }
}
