package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

@Getter @Setter
@ToString
public class MemberDto {
    private String name;
    private String email;

//    @Override
//    public String toString() {
//        return "MemberDto (name=" + getName() + ", email=" + getEmail() + ")";
//    }
}
