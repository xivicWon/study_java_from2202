package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @AfterEach
    void initRepository () {
        memoryMemberRepository.clearStore();
    }

    @Test
    @DisplayName("MemberRepository 저장")
    void save(){
        //Given
        Member member = new Member();
        member.setName("원재호");

        //When
        memoryMemberRepository.save(member);
        // Optional 은 있거나 없거나.

        //Then
        Optional<Member> optionalMember = memoryMemberRepository.findById(member.getId());
        Member savedMember = optionalMember.orElse(null);   // Optional 은 있거나 없거나함.
        assertThat(savedMember).isEqualTo(member);

        /*
        assertThat(savedMember.getId()).isEqualTo(1);
        assertThat(savedMember).isEqualTo(member);

        System.out.println("member = " + member);
        System.out.println("savedMember = " + savedMember);
        */
    }

    @Test
    @DisplayName("이름찾기 함수")
    void findByName(){
        //Given
        Member member = new Member();
        member.setName("김갑수");
        memoryMemberRepository.save(member);

        //When
        Optional<Member> findMember  = memoryMemberRepository.findByName(member.getName());
        Member savedMember = findMember.orElse(null);   // Optional 은 있거나 없거나함.

        //Then
        assertThat(savedMember).isEqualTo(member);
    }

    @Test
    @DisplayName("모든 사용자 조회")
    void findAll(){
        //Given
        Member member = new Member();
        member.setName("김갑수");
        memoryMemberRepository.save(member);
        Member member2 = new Member();
        member2.setName("김갑수2");
        memoryMemberRepository.save(member2);
        Member member3 = new Member();
        member3.setName("김갑수3");
        memoryMemberRepository.save(member3);

        //When
        List<Member> findMembers  = memoryMemberRepository.findAll();

        //Then
        assertThat(findMembers.size()).isEqualTo(3);

    }
}