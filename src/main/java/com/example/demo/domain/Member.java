package com.example.demo.domain;

// 도메인 ( business domain ) : 업무 영역
// 클래스(정의) = 필드(속성) + 매서드(행위)

import lombok.Getter;
import lombok.Setter;

// 필드 vs 프로퍼티

// Lombok ( build.gradle 에서 보면 compileOnly 에 있음 - compile 과정에서 생성되기 때문에 실무에서 잘 씀.)
@Getter @Setter
public class Member {

    private Long id ;
    private String name ;

//    Alt + insert
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}



