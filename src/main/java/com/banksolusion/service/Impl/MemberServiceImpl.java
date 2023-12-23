package com.banksolusion.service.Impl;

import com.banksolusion.entity.Member;
import com.banksolusion.enums.ResultEnum;
import com.banksolusion.exception.MyException;
import com.banksolusion.repository.MemberRepository;
import com.banksolusion.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@Service
@DependsOn("passwordEncoder")
public class MemberServiceImpl implements MemberService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    MemberRepository memberRepository;


    @Override
    public Member findOne(String email) {
        return memberRepository.findByEmail(email);
    }

    @Override
    public Collection<Member> findByRole(String role) {
        return memberRepository.findAllByRole(role);
    }

    @Override
    @Transactional
    public void save(Member member) {
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        try {
            memberRepository.save(member);
        } catch (Exception e) {
            throw new MyException(ResultEnum.VALID_ERROR);
        }

    }

    @Override
    public void update(Member member) {
        Member oldMember = memberRepository.findByEmail(member.getEmail());

        oldMember.setPassword(passwordEncoder.encode(member.getPassword()));
        oldMember.setName(member.getName());
        oldMember.setAddress1(member.getAddress1());
        oldMember.setAddress2(member.getAddress2());
        oldMember.setPhone(member.getPhone());
        oldMember.setType(member.getType());
        
        memberRepository.save(oldMember);
    }
}
