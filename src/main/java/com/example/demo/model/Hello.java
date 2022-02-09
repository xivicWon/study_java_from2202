package com.example.demo.model;

public class Hello {

    public int add(int x, int y) {
        return x + y;
    }

    public int minus(int x, int y) {
        return x - y;
    }

    public int multi(int x, int y) {
        return x * y;
    }

    public int divide(int x, int y) {
        if( x == 0 || y == 0 ){
            return 0;
        }

        return x / y;
    }
}
