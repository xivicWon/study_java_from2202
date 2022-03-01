package com.example.demo.code;

/*
인터페이스 이름의 유형은 명사, 형용사 형식으로 쓰기도 함
@FunctionalInterface 은 함수형 인터페이스를 명시적으로 표현해 준다. ( 활성 함수를 한개만 사용가능하도록 제한해줌 )
 */
@FunctionalInterface
public interface Callable {
    void call();

}
