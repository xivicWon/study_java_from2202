package com.example.demo.service;

import com.example.demo.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    private final MemberService memberService;

    @BeforeEach
    void initMemberService(){
        memberService.clearMember();
    }

    @Autowired
    MemberServiceTest(MemberService memberService) {
        this.memberService = memberService;
    }


    @Test
    @DisplayName("회원가입 ?회원제공")
    void join() {
        //Given
        Member member = new Member();
        member.setName("오로라");

        //When
        Long memberID = memberService.join(member);

        //Then
        assertThat(memberID).isEqualTo(member.getId());

    }

    @Test
    @DisplayName("전체 회원 조회 ?회원제공")
    void getAllMembers() {

        //Given
        Member member = new Member();
        member.setName("오로라");
        Member member2 = new Member();
        member2.setName("오로라2");
        Member member3 = new Member();
        member3.setName("오로라3");
        memberService.join(member);
        memberService.join(member);
        memberService.join(member);

        //When
        List<Member> allMembers = memberService.getAllMembers();

        //Then
        assertThat(allMembers.size()).isEqualTo(3);

    }

    @Test
    @DisplayName("전체 회원 조회 ?회원미제공")
    void getAllMembers_NotFound() {

        //Given

        //When
        List<Member> allMembers = memberService.getAllMembers();

        //Then
        assertThat(allMembers.size()).isEqualTo(0);

        System.out.println("allMembers = " + allMembers);

    }

    @Test
    @DisplayName("회원조회 ?조회")
    void getMember() {
        //Given
        Member member = new Member();
        member.setName("돌로렌스");
        memberService.join(member);

        //When
        Member findMember = memberService.getMember(member.getId());

        //Then
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    @DisplayName("회원조회 ?미조회")
    void getMember_NotFound() {
        //Given
        Member member = new Member();
        member.setName("돌로렌스");
        memberService.join(member);

        //When
        Member findMember = memberService.getMember(2L);

        //Then
        assertThat(findMember).isEqualTo(null);
    }
}