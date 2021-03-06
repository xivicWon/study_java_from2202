package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository{

    private final Map<Long , Member >  store = new HashMap<>();
    private static Long sequence = 0L;

    // 없어도 에러는 발생되지 않음. 하지만 해주자.
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = store.get(id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Boolean dormant(Member member) {
        return null;
    }

    @Override
    public Boolean out(Member member) {
        return null;
    }


    @Override
    public void clearStore(){
        store.clear();
        sequence = 0L;
    }
}
