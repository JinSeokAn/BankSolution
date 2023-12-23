package com.banksolusion.service;

import com.banksolusion.entity.Member;

import java.util.Collection;

public interface MemberService {

    Member findOne(String email);

    Collection<Member> findByRole(String role);

    void save(Member member);

    void update(Member member);

}
