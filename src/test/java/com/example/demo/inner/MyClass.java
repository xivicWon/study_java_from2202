package com.example.demo.inner;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyClass {
    public String instanceField;
    public static String staticField;


    // static method
    public void instanceMethod(){
        log.info("MyClass.instanceMethod");
    }
    public static void staticMethod(){
        log.info("MyClass.staticMethod");
    }


    // inner Class
    public class MyInnerClass{
        public void call(){
            // 자바스크립트를 예로 들면 특정 객체의 properties 에 현재 객체 주소를 대입하여 위치를 찾는 방식? 이랄까...

            MyClass.this.instanceField = "MyInnerClass.call";
            MyClass.staticField = "MyInnerClass.call";
        }
    }

    public static class MyStaticClass{
        public void call(){
//            MyClass.this.instanceField = "MyInnerClass.call"; >> impossible
            MyClass.staticField = "MyInnerClass.call";
        }
    }
}
