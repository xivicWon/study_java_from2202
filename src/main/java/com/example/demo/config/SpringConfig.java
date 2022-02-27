package com.example.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import com.example.demo.repository.JdbcMemberRepository;
import com.example.demo.repository.JdbcTemplateMemberRepository;

import javax.sql.DataSource;

@Configuration  // @Component 와는 차이가 있다.
// Configuration 구성.
public class SpringConfig {

    @Bean
    public MemberRepository memoryMemberRepository(DataSource dataSource) {
        return new JdbcTemplateMemberRepository(dataSource);

//        return new JdbcMemberRepository(dataSource);

//        return new MemoryMemberRepository();
    }


    //SOLID 원칙
}
