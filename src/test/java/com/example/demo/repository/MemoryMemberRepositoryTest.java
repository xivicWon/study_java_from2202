package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @Test
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


}