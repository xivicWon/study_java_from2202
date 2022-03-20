package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.JdbcMemberRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    private MemberService memberService;
//    private MemberService memberService;

    @BeforeEach
    void initMemberService(){
//        MemberRepository memoryMemberRepository = new MemoryMemberRepository();
//        MemberRepository memoryMemberRepository = new JdbcMemberRepository();
//        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach
    void initMemberServiceAfterEach(){
//        memoryMemberRepository.clearStore();
    }

    @Test
    @DisplayName("테스트 DI")
    void testDI () {
        System.out.println("memberService = " + memberService);
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
    @DisplayName("회원가입 ?중복이름")
    @Rollback(false)
    void join_DuplicateName() {
        //Given
        Member member1 = new Member();
        member1.setName("빵꾸똥꾸");
        Member member2 = new Member();
        member2.setName("빵꾸똥꾸");
        memberService.join(member1);

        // When
        ThrowableAssert.ThrowingCallable throwingCallable = () -> memberService.join(member2);

        // Then
        assertThatThrownBy(throwingCallable).hasMessage("중복된 이름이 있습니다.");


        // When
//        ThrowableAssert.ThrowingCallable throwingCallable2 = () -> memberService.join(member2);

        // Then
//        assertThatThrownBy(throwingCallable2).isInstanceOf(IllegalStateException.class);
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
        System.out.println("member.getId() = " + member.getId());
        System.out.println("findMember.getId() = " + findMember.getId());
        assertThat(findMember.getName()).isEqualTo(member.getName());
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

    @Test
    @DisplayName("")
    void testString () {
        String str1 = new String("abc");
        String str2 = new String("abc");
        String str3 = "abc";    // 스트링 리터럴
        String str4 = "abc";    // 스트링 리터럴

        assertThat(str1).isEqualTo(str2);
        assertThat(str1).isNotSameAs(str3);
        assertThat(str1).isEqualTo(str4);

        assertThat(str2).isEqualTo(str3);
        assertThat(str2).isEqualTo(str4);

        assertThat(str3).isEqualTo(str4);


    }





}