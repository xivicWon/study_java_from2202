package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {

    private MemberService memberService;
    private MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    void initMemberService(){
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }
    @AfterEach
    void initMemberServiceAfterEach(){
        memoryMemberRepository.clearStore();
    }


    @Test
    @DisplayName("회원가입 ?가입성공")
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
    @DisplayName("회원가입 ?가입실패")
    void join_Exception() {
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
        member.setName("A");
        memberService.join(member);
        Member member2 = new Member();
        member2.setName("B");
        memberService.join(member2);

        //When
        List<Member> allMembers = memberService.getAllMembers();

        //Then
        assertThat(allMembers.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("전체 회원 조회 ?회원미제공")
    void getAllMembersWhenEmpty() {
        //Given

        //When
        List<Member> allMembers = memberService.getAllMembers();

        //Then
        assertThat(allMembers).isEmpty();
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
    void getMemberNotFound() {
        //Given
        Member member = new Member();
        member.setName("돌로렌스");
        memberService.join(member);

        //When
        Member findMember = memberService.getMember(300L);

        //Then
        assertThat(findMember).isEqualTo(null);
    }
}