package com.example.demo.service;

public class MemberFacade {

    public MemberFacade() {

    }

    public void out (Long memberId){
        // 회원 정보 일부 저장
        // 회원 정보 삭제
        // 로그아웃
    }


    public void dormant (Long memberId){
        // 회원 정보 이관 ( 타 DB 서버로 이관 )
        // 현재 회원의 개인정보 제거 및 휴면 처리.
    }

    public void resurrection (Long memberId){
        // 회원 정보 타 서버에서 Load
        // Load 된 회원 정보 반영
    }


}
