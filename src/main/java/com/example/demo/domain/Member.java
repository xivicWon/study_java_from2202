package com.example.demo.domain;

// 도메인 ( business domain ) : 업무 영역
// 클래스(정의) = 필드(속성) + 매서드(행위)

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// 필드 vs 프로퍼티

// Lombok ( build.gradle 에서 보면 compileOnly 에 있음 - compile 과정에서 생성되기 때문에 실무에서 잘 씀.)

// JPA ( Java Persistence API ) 방식
// 스프링 표준 ORM ( Object-Relational Mapping ) - 객체 관계 맵핑
// -> JAP -> 스팩, 규격, 명세
// 구현체 : Hibernate, Etc...

@Entity // @Id 필수, 기본 생성자(파라미터가 없는 생성자)가 있어야 함.
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    //Json 의 데이터가 null 이면 제외함.
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    @Id @GeneratedValue()
    private Long id ;       // Primitive Type
    private String name ;

    public Member(String name) {
        this.name = name;
    }

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



