package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    // 담는 그릇은 인터페이스 ... 담으려는것은 클래스 .. 왜일까?
    // 유연성을 위하여 상위개념인 인터페이스에 할당하는 것이 좋은 방식이다.

    // 필드주입의 단점 : Spring 에서만 주입이 가능하다. 즉, 테스트 코드에서 Spring 을 안쓰면 사용이 불가능하다.

    private final MemberRepository repository;


    // 의존성(Dependency)
    // 생성자의 파라미터는 상위타입(슈퍼타입)을 지정하는것이 좋다.
    // 클래스 필드 또는 메소드 파라미터에는 상위타입을 사용하는 것이 좋다. 으아아.~
    @Autowired  // 생성자가 1개일 경우에는 생략이 가능하다.
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    /**
     * 회원가입 - 이름을 Join 이라고 한 것은 서비스가 비지니스 로직이기 때문이다.!!
     * @param member 가입할 회원객체
     * @return member ID
     */
    public Long join(Member member) {
        checkDuplicatedMember(member);
        return repository.save(member).getId();
    }

    private void checkDuplicatedMember(Member member) {
        if (repository.findByName(member.getName()).isPresent()) {
            throw new IllegalStateException("중복된 이름이 있습니다.");
        }
    }

    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    /**
     * @param id 사용자 ID
     * @return member ID
     */
    public Member getMember(Long id) {
        return repository.findById(id).orElse(null);
    }
}