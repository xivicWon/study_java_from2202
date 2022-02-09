package com.example.demo.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(4, 6);
        Assertions.assertThat(result).isEqualTo(10);
    }

    @Test
    void testMinus() {
        Calculator calculator = new Calculator();
        int result = calculator.minus(8, 6);
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    void testMulti() {
        Calculator calculator = new Calculator();
        int result = calculator.multi(1, 5);
        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    @Disabled
    void testDivide2() {
        Calculator calculator = new Calculator();
        int x = 5;
        int y = 0;

        // when
        Executable executable = () -> calculator.divide(x, y);

        // then
        org.junit.jupiter.api.Assertions.assertThrows(ArithmeticException.class, executable);

        // when
//        ThrowableAssert.ThrowingCallable throwingCallable = () -> hello.divide(x, y);

        // then
//        Assertions.assertThatThrownBy(throwingCallable).isInstanceOf(ArithmeticException.class);

    }


    @Test
    void testDivide() {
        Calculator calculator = new Calculator();
        int x = 5;
        int y = 5;
        int result = calculator.divide(x, y );

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void testDivideByZeroX() {
        Calculator calculator = new Calculator();
        int x = 0;
        int y = 5;
        int result = calculator.divide(x, y );

        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    void testDivideByZeroY() {
        Calculator calculator = new Calculator();
        int x = 5;
        int y = 0;
        int result = calculator.divide(x, y );

        Assertions.assertThat(result).isEqualTo(0);
    }
}
