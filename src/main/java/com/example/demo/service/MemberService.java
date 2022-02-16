package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    // 담는 그릇은 인터페이스 ... 담으려는것은 클래스 .. 왜일까?
    // 유연성을 위하여 상위개념인 인터페이스에 할당하는 것이 좋은 방식이다.

    private final MemberRepository repository;

    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }


    /**
     * 이름을 Join 이라고 한 것은 서비스가 비지니스 로직이기 때문이다.!!
     * @param member
     * @return member_id
     */
    public Long join(Member member){
        return repository.save(member).getId();
    }

    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    public Member getMember(Long id){
        return repository.findById(id).orElse(null);
    }

}
