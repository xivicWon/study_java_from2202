package com.example.demo.config;
import com.example.demo.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration  // @Component 와는 차이가 있다.
// Configuration 구성.
public class SpringConfig {


    // DataSource 와 EntityManager 는 선언안해도 기본적으로 Bean 에 등록되어 있기 때문에 자동으로 등록된다.
//    @Bean     //@Bean 을 주석처리하면 사용이 안됨.
    public MemberRepository memberRepository(/*DataSource dataSource*/ EntityManager em ) {
        return new JpaMemberRepository(em);

//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JdbcMemberRepository(dataSource);
//        return new MemoryMemberRepository();
    }
}
