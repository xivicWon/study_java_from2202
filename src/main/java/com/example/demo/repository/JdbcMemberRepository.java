package com.example.demo.repository;


import com.example.demo.domain.Member;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//@Repository
public class JdbcMemberRepository implements MemberRepository {

    private final DataSource dataSource;

    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Member save(Member member) {
        String sql = "insert into member(name) values(?)";
        try (Connection conn = getConnection();
             PreparedStatement stat = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
            ) {
            // setString => params binding
            stat.setString(1, member.getName());
            stat.executeUpdate();
            try (ResultSet rs = stat.getGeneratedKeys()) {
                if (rs.next()) {
                    member.setId(rs.getLong(1));
                } else {
                    throw new SQLException("id 조회 실패");
                }
            }
            return member;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }


    @Override
    public Optional<Member> findById(Long id) {
        String sql = "select * from member where id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stag = conn.prepareStatement(sql);
             ){
            stag.setLong(1, id);
            try (ResultSet rs = stag.executeQuery()) {
                if (rs.next()) {
                    Member member = new Member();
                    member.setId(rs.getLong("id"));
                    member.setName(rs.getString("name"));
                    return Optional.of(member);
                } else {
                    return Optional.empty();
                }
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        String sql = "select * from member";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            List<Member> members = new ArrayList<>();
            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getLong("id"));
                member.setName(rs.getString("name"));
                members.add(member);
            }
            return members;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
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
    public Optional<Member> findByName(String name) {
        String sql = "select * from member where name = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            try(ResultSet rs = pstmt.executeQuery()){
                if (rs.next()) {
                    Member member = new Member();
                    member.setId(rs.getLong("id"));
                    member.setName(rs.getString("name"));
                    return Optional.of(member);
                }
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }

}
