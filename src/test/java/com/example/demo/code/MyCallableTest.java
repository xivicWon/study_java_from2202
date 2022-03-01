package com.example.demo.code;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;

class MyCallableTest {

    @Test
    void call_0 (){
        // 익명 객체 ( interface ) => 익명 함수 ( 람다 )  => 메소드 레퍼런스
        IntBinaryOperator operator = Math::min;
        Runnable r = () -> System.out.println("runable = ");
        r.run();

        // Primitive Type : int, long, string
        // Wrapper Type : Int, Long, String
        // Reference Type : etc

        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "test";
            }
        };

        Supplier<String> supplierLambda = () -> "test";

        supplier.get();

    }

    @Test
    void call_1() {
        System.out.println("MyCallableTest.call_1()");
        Callable callable = new MyCallable();
        callable.call();
        System.out.println("this 2 = " + this);
        System.out.println("callable = " + callable);
    }

    @Test
    void call_2() {
        System.out.println("MyCallableTest.call_2()");
        Callable callable = new Callable() {
            // 익명 구현 클래스 ( 이름이 없어서 )
            @Override
            public void call() {
                System.out.println("this noname = " + this);
            }

        };
        Callable callable2 = new Callable() {
            // 익명 구현 클래스 ( 이름이 없어서 )
            @Override
            public void call() {
                System.out.println("this noname 2= " + this);
            }

        };
        System.out.println("this 2 = " + this);
        callable.call();
        System.out.println("callable = " + callable);
        callable2.call();
        System.out.println("callable2 = " + callable2);
    }

    @Test
    void call_3() {
        System.out.println("MyCallableTest.call_3()");
        // 람다 -
        // 람다는 this 가 다르다.
        // 람다 캡쳐링 - 람다가 실행될 때 메모리 동작
        // 람다는 구현 대상 인터페이스의 메소드가 1개 여야 한다.
        Callable callable = () -> System.out.println("this noname = " + MyCallableTest.this);

        System.out.println("this 2 = " + this);
        callable.call();
        System.out.println("callable = " + callable);
    }

}