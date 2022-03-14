package com.kyu.chapter05.chapter0505;

import com.kyu.common.SampleData;
import io.reactivex.Observable;

public class Quiz {
    public static void main(String[] args) {
        /**
         * zip을 이용하여 각 지점별 월별 매출(SampleData.salesOfBranchA, SampleData.salesOfBranchB, SampleData.salesOfBranchC)을
         * 월별로 합산하여 통합 월별 매출을 출력하세요.
         * (지점별 월별 매출 List(salesOfBranchA, salesOfBranchB, salesOfBranchC)는 index가 빠른 요소부터 1월입니다.)
         */

        Observable<Integer> observable1 = Observable.fromIterable(SampleData.salesOfBranchA);
        Observable<Integer> observable2 = Observable.fromIterable(SampleData.salesOfBranchB);
        Observable<Integer> observable3 = Observable.fromIterable(SampleData.salesOfBranchC);
        Observable<Integer> observable4 = Observable.range(1,12);

        Observable.zip(
                observable1, observable2, observable3, observable4,
                (data1, data2, data3, mm) -> mm + "월  총 매출 : " + (data1 + data2 + data3) )
                .subscribe(data -> System.out.println(data));

    }
}
