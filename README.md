
#Kevin의 알기 쉬운 RxJava  따라하기
- https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EB%A6%AC%EC%95%A1%ED%8B%B0%EB%B8%8C%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D-1

## 리액티브 프로그래밍이란?
    - 변화의 전파와 데이터 흐름과 과련된 선언적 프로그래밍 패러다임

    > 변화의 전파와 데이터 흐름 : 데이터가 변경될 때 마다 이벤트를 발생시켜서 데이터를 계속적으로 전달한다.
    > 선언적 프로그래밍 : 실행할 동작을 구체적으로 명시하는 명령형 프로그래밍과 달리 선언형 프로그래밍은 단순히 목표를 선언한다.


## 리액티브의 개념이 적용된 예
    1) Push 방식 : 데이터의 변화가 발생했을 때 변경이 발생한 곳에서 데이터를 보내주는 방식
        ex) RTC, 소켓 프로그래밍, DB Trigger, Spring의 ApplicationEvent, 스마트폰의 Push 메시지
        
    2) Puul 방식 : 변경된 데이터가 있는지 요청을 보내 질의하고 변경된 데이터를 가져오는 방식
        ex) 클라이언트 요청 & 서버 응답 방식의 애플리케이션
            Java와 같은 절차형 프로그래밍 언어

    > 리액티브 브래그랭밍도 Push 방식이다.        


## 리액티브 프로그래밍을 위해 알아야 될 것들
    1) Observable : 데이터 소브
    2) 리액티브 연산자(Operators) : 데이터 소스를 처리하는 함수
    3) 스케쥴러(Scheduler) : 스레드 관리자 
    4) Subscriber : Observable이 발행하는 데이터를 구독하는 구독자
    5) 함수형 프로그래밍 : RxJava에서 제공하는 연산자(Operator) 함수를 사용


## RxJava의 기본 프로세스
    1) 발행
    2) 가공
    3) 구독
    4) 처리

## 마블 다이어그램이란?
    - 리액티브 프로그래밍을 통해 발행하는 비동기적인 데이터 흐름을 시간의 흐름에 따라 시각적으로 표시한 다이어 그램

### 마블 다이어그램을 알아야 하는 이유
    - 문장으로 작성된 리액티브 연산자(Operators)의 기능을 이해하기 어려후나   
      시각화 되어 있는 리액티브 연산자는 이해햐기 쉽다.
    - 리액티브 프로그램잉의 핵심인 연산자(Operators)를 사용하기 위한 핵심 도구


![image](https://user-images.githubusercontent.com/8993602/155144524-b1279e49-0e91-4ee5-bd6d-ac18a8c5359c.png)


## 리액티브 스트림즈(Reactive Streams)란?
 - 리액티브 프로그래밍 라이브러리의 표준 사양이다.   
   (https://github.com/reactive-streams/reactive-streams-jvm)
 - 리액티브 프로그래밍에 대한 인터페이스만 제공한다.
 - RxJava는 이 Reactive Streams의 인터페이스들을 구현한 구현체 이다.
 - Reactive Streams는 4개의 인터페이스를 제공한다.
    > Publisher : 데이터를 생성하고 통지한다.  
    > Subscriber : 통지된 데이터를 전달받아서 처리한 다.  
    > Subscription : 전달 받을 데이터의 갯수를 요청하고 구독을 해지한다.   
    > Processor : Publisher와 Subscriber의 기능이 모두 있다.

![image](https://user-images.githubusercontent.com/8993602/155240099-b5e7f376-bbc7-430c-8cd1-414606c3a499.png)

## Cold Publisher & Hot Publisher
    1) Cold Publisher
        - 생산자는 소비자가 구독 할때마다 데이터를 처음부터 새로 통지한다.
        - 데이터를 통지하는 새로운 타임 라인이 생성된다.
        - 소비자는 구독 시점과 상관없이 통지된 데이터를 처음부터 전달 받을 수 있다.
    2) Hot Publisher
        - 생산자는 소비자 수와 상관없이 데이터를 한번만 통지한다.
        - 데이터를 통지하는 타임 라인은 하나이다.
        - 소비자는 발행된 데이터를 처음부터 전달 받는게 아니라 구독한 시점에 통지된 데이터들만 전달 받을 수 있다.

## Flowable과 Observable의 비교
    - Flowable, Observable 모두 데이터를 통지하는 생산자

|Flowable|Observable|
|--------|----------|
|Reactive Streams 인테페이스를 구현 함 | Reactive Streams 인테페이스를 구현 하지않고, RxJava2 독자적으로 제공해주는 클래스| 
|Subscriber에서 데이터를 처리한다. | Observer에서 데이터를 처리한다. |
|데이터 개수를 제어하는 배압 기능이 있음 | 데이터 개수를 제어하는 배압 기능이 없음|
|Subscription으로 전달 받는 데이터 개수를 제어할 수 있다. | 배압 기능이 없기 때문에 데이터 개수를 제어할 수 없다. |
|Subscription으로 구독을 해지한다. | Disposable로 구독을 해지한다. |

### 배압(Back Pressure)이란?
    - Flowable에서 데이터를 통지하는 속도가 Subscriber에서 통지된 데이터를 전달받아 처리하는 속도 보다 빠를 때 밸런스를 맞추기 위해 데이터 통지량을 제어하는 기능을 말한다.

![image](https://user-images.githubusercontent.com/8993602/155624163-57ab46ea-82b8-44b5-bc69-432fe5c04e3f.png)

### 배압 전략(BackpressureStrategy)
 - Rxjava에서는 BackpressureStrategy를 통해 Flowable이 통지 대기 중인 데이터를 어떻게 다룰지에 대한 배압 전략을 제공한다.

    1) MISSING 전략
        - 배압을 적용하지 않는다.
        - 나중에 onBackpressureXXX()으로 배압 적용을 할 수 있다.

    2) ERROR 전략
        - 통지된 데이터가 버퍼의 크기를 초과하면 MissingBackpressureExcption에러를 통지한다.
        - 소비자가 생산자의 통지 속도를 따라 잡지 못할 때 발생한다.

    3) BUFFER 전략 : DROP_LATEST   
        - 버퍼가 가득 찬 시점에 버퍼내에서 가장 최근에 버퍼에 들어온 데이터를 Drop 한다.
        - Drop 된 빈 자리에 버퍼 밖에서 대기하던 데이터를 채운다.

    4) BUFFER 전략 : DROP_OLDEST
        - 버퍼가 가득 찬 시점에 버퍼내에서 가장 오래전에(먼저) 버퍼로 들어온 데이터를 Drop한다.
        - Drop 된 빈 자리에는 버퍼 밖에서 대기하던 데이터를 채운다.

    5) DROP 전략
        - 버퍼에 데이터가 모두 채워진 상태가 되면 이후에 생성되는 데이터를 버리고(Drop), 버퍼가 비워지는 시점에 Drop되지 않은 데이터부터 다시 버퍼에 담는다.

    6) LATEST 전략
        - 버퍼에 데이터가 모두 채워진 상태가 되면 버퍼가 비워질 때까지 통지된 데이터는 버퍼 밖에서 대기하며, 버퍼가 비워지는 시점에 가장 나중에(최근에) 통지된 데이터부터 버퍼에 담는다.


## Singel
    - 데이터를 1건만 통지하거나 에러를 통지한다.
    - 데이터를 통지 자체가 완료를 의미하기 때문에 완료 통지는 하지 않는다.
    - 데이터를 1건만 통지하므로 데이터 개수를 요청할 필요가 없다.
    - onNext(), onComplete()가 없으며, 이 둘을 합한 onSuccess()를 제공한다.
    - Single의 대표적인 소비자의 SingleObserver이다.
    - 클라이던트의 요청에 대응하는 서버의 응답이 Single을 사용하기 좋은 대표적인 예다.

## Maybe 
    - 데이터를 1건만 통지하거나 1건도 통지하지 않고 완료 또는 에러를 통지한다.
    - 데이터를 통지 자체가 완료를 의미하기 때문에 완료 통지는 하지 않는다.
    - 데이터를 1건도 통지하지 않고 처리가 종료될 경우에는 완료 통지를 한다.
    - Maybe의 대표적인 소비자는 MaybeOserver이다.

## Completable
    - 데이터 생산자이지만 데이터를 1건도 통지하지 않고 완료 또는 에러를 통지한다.
    - 데이터를 통지의 역활 대신에 Completable 내에서 특정 작업을 수행한 후, 해당 처리가 끝났음을 통지하는 역활을 한다.
    - Completable의 대표적인 소비자는 CompletableObserver이다.


## RxJava의 연산자란(Operator)란?
    - RxJava에서의 연산자는 메서드(함수)이다.
    - 연산자를 이용하여 데이터를 생성하고 통지하는 Flowable이나 Observable 등의 생산자를 생성할 수 있다.
    - Flowable이나 Observable에서 통지한 데이터를 다양한 연사자를 사용하여 가공 처리하여 결과값을 만들어 낸다.
    - 연산자의 특성에 따라 카테고리로 분류된다.

### Flowable/Observable 생성 연산자

#### 1. interval
    - 지정한 시간 간격마다 0부터 시작하는 숫자(Long)를 통지한다.
    - initialDelay 파라미터 이용해서 최초 통지에 대한 대기 시간을 지정할 수 있다.
    - 완료 없이 계속 통지한다.
    - 호출한 스레드와 별도의 스레드에서 실행된다.
    - polling 용도의 작업을 수행할 때 활용할 수 있다.

#### 2. range
    - 지정한 값(n)부터 m개의 숫자(Integer)를 통지한다.
    - for, while 문 등의 반복문을 대체할 수 있다.

#### 3. timer
    - 지정한 시간이 지나면 0(Long)을 통지한다.
    - 0을 통지하고 onComplete() 이벤트가 발생하여 종료한다.
    - 호출한 스레드와는 별도의 스레드에서 실행된다.
    - 특정 시간을 대기한 후에 어떤 처리를 하고자 할 때 활용할 수 있다.

#### 4. defer
    - 구독이 발생할 때마다 즉, subscribe()가 호출될 때마다 새로운 Observable를 생성한다.
    - 선언한 시점의 데이터를 통지하는 것이 아니라 호출 시점의 데이터를 통지한다.
    - 데이터 생성을 미루는 효과가 있기 때문에 최신 데이터를 얻고자할 때 활용할 수 있다.

#### 5. fromIterable
    - Iterable 인터페이스를 구현한 클래스(ArrayList 등)를 파라미터로 받는다.
    - Iterable에 담긴 데이터를 순서대로 통지한다.

#### 6. fromFuture
    - Future 인터페이스는 Java 5에서 비동기 처리를 위해 추가된 동시성 API이다.
    - 시간이 오래 걸리는 작업은 Future를 반환하는 ExcutorService에게 맡기고 비동기로 다른 작업을 수행할 수 있다.
    - Java 8에서는 CompletableFuture 클래스를 통해 구현이 간결해졌다.