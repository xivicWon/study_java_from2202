package com.example.demo.code;

public class MyCallable implements Callable{

    @Override
    public void call() {
        // this 는 현재 메소드가 속한 객체
        System.out.println("this 1 = " + this);
    }
}
