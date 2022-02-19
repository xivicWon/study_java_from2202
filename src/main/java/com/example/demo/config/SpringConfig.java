package com.example.demo.config;

import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration  // @Component 와는 차이가 있다.
// Configuration 구성.
public class SpringConfig {

    @Bean
    public MemberRepository memoryMemberRepository(){
        return new MemoryMemberRepository();
    }

}
