package com.example.demo.code;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Consumer;
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

    @Test
    void runnable (){
        // alt + Enter 하면 익명 함수로 변환 가능
        Runnable runnable = () -> System.out.println(" * running * ");
        runnable.run();
    }

    @Test
    void supplier (){
        // alt + Enter 하면 익명 함수로 변환 가능
        Supplier<String> supplier = () -> "supplier";
        System.out.println(supplier.get());
    }

    @Test
    void consumer1 () {
        // replace lamba with anonymous class (alt + Enter)
        Consumer<Integer> consumer1 = i -> System.out.println("i1 = " + i);
        Consumer<Integer> consumer2 = i -> System.out.println("i2 = " + i);
        Consumer<Integer> consumer3 = i -> System.out.println("i3 = " + i);

        consumer1.andThen(consumer2).andThen(consumer3).accept(9999);
    }

    @Test
    void function(){
        Function<Integer, Boolean> function = i -> i > 0;
        System.out.println("function1 = " + function.apply(100));
        System.out.println("function2 = " + function.apply(0));

    }

    @Test
    void function2(){

        Function<Integer, Integer> multiply = (value) -> value * 2;
        Function<Integer, Integer> add      = (value) -> value + 3;

        Function<Integer, Integer> addThenMultiply = multiply.compose(add);

        System.out.println("multiply.andThen(add).apply(4) = " + multiply.andThen(add).apply(4));
        System.out.println("multiply.compose(add).apply(4) = " + multiply.compose(add).apply(4));
        Integer result1 = addThenMultiply.apply(3);
        System.out.println(result1);
    }


    @Test
    void optional () {
        // 정적 생성자 메소드 패턴
        String s = null;
        Optional<String> s2 = Optional.ofNullable(s);
        String str2 = s2.orElse("default");
        System.out.println("str2 = "  + str2);
        Optional<String> empty = Optional.empty();
    }
}