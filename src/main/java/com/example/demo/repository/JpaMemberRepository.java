package com.example.demo.repository;

import com.example.demo.domain.Member;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Slf4j
public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        log.info("JpaMemberRepository >>> findByName ");
        String jpql = "SELECT m FROM Member m WHERE name = :name";
        List<Member> members = em.createQuery(jpql, Member.class)
                .setParameter("name" , name)
                .getResultList();
        return members.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        String jpql = "SELECT m FROM Member m";
        return em.createQuery(jpql, Member.class).getResultList();
    }

    @Override
    public Boolean dormant(Member member) {
        return null;
    }

    @Override
    public Boolean out(Member member) {
        return null;
    }
}
