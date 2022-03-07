package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends MemberRepository , JpaRepository<Member, Long> {

    Optional<Member> findByName(String name);

}
