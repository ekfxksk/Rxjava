package com.kyu.chapter05.chapter0504;

import com.kyu.common.CarMaker;
import com.kyu.common.SampleData;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.Map;

public class Quiz {
    public static void main(String[] args) {
        Single<Map<String, CarMaker>> single = Observable.fromIterable(SampleData.carList)
                                    .toMap(
                                            data -> data.getCarName(),
                                            data -> data.getCarMaker()
                                    );
        single.subscribe(data -> System.out.println("On Next : " + data ));

    }
}
