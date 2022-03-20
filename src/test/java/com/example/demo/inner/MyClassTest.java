package com.example.demo.inner;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class MyClassTest {
    @Test
    void test(){
        MyClass myClass = new MyClass();
        myClass.instanceField = "aaa";
        MyClass.staticField = "ccc";

        log.info(" >>> 1.instanceField >> " + myClass.instanceField  );
        log.info(" >>> 1.staticField >> " + MyClass.staticField);

        MyClass myClass2 = new MyClass();
        myClass2.instanceField = "bbb";
        MyClass.staticField = "ddd";

        log.info(" >>> 2.instanceField >> " + myClass2.instanceField );
        log.info(" >>> 2.staticField >> " + MyClass.staticField);


        log.info(" >>> 1.instanceField >> " + myClass.instanceField  );
        log.info(" >>> 1.staticField >> " + MyClass.staticField);

        myClass.instanceMethod();
        MyClass.staticMethod();
    }


    // 동일성과 동등성
    // 동일성 : 참조 주소가 같음.
    // 동등성 : 내용이 같다.

    // DTO vs VO 구분.
    @Test
    void testClass(){
        // 이너 클래스 객체 생성
        MyClass myClass = new MyClass();
        MyClass.MyInnerClass myInnerClass1 = new MyClass().new MyInnerClass();
        MyClass.MyInnerClass myInnerClass2 = myClass.new MyInnerClass();
        log.info(" 동일성 ] inner Class > {}" , (myInnerClass1 == myInnerClass2 ));
        log.info(" 동등성 ] inner Class > {}" , (myInnerClass1.equals(myInnerClass2)));

        MyClass.MyStaticClass myStaticClass1 = new MyClass.MyStaticClass();
        MyClass.MyStaticClass myStaticClass2 = new MyClass.MyStaticClass();
        log.info(" static Class > {}" , (myStaticClass1.equals(myStaticClass2)));
    }
}
