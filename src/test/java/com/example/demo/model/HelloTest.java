package com.example.demo.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class HelloTest {

    @Test
    void testAdd() {
        Hello hello = new Hello();
        int result = hello.add(4, 6);
        Assertions.assertThat(result).isEqualTo(10);
    }

    @Test
    void testMinus() {
        Hello hello = new Hello();
        int result = hello.minus(8, 6);
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    void testMulti() {
        Hello hello = new Hello();
        int result = hello.multi(1, 5);
        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    @Disabled
    void testDivide2() {
        Hello hello = new Hello();
        int x = 5;
        int y = 0;

        // when
        Executable executable = () -> hello.divide(x, y);

        // then
        org.junit.jupiter.api.Assertions.assertThrows(ArithmeticException.class, executable);

        // when
//        ThrowableAssert.ThrowingCallable throwingCallable = () -> hello.divide(x, y);

        // then
//        Assertions.assertThatThrownBy(throwingCallable).isInstanceOf(ArithmeticException.class);

    }


    @Test
    void testDivide() {
        Hello hello = new Hello();
        int x = 5;
        int y = 5;
        int result = hello.divide(x, y );

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void testDivideByZeroX() {
        Hello hello = new Hello();
        int x = 0;
        int y = 5;
        int result = hello.divide(x, y );

        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    void testDivideByZeroY() {
        Hello hello = new Hello();
        int x = 5;
        int y = 0;
        int result = hello.divide(x, y );

        Assertions.assertThat(result).isEqualTo(0);
    }
}
