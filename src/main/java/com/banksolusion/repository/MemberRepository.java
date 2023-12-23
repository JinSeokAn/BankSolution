package com.banksolusion.repository;


import com.banksolusion.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
    Collection<Member> findAllByRole(String role);
}
