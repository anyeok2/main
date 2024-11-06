package com.example.anyeok.domain.member.service;

import com.example.anyeok.domain.member.entity.Member;
import com.example.anyeok.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member join(String username, String password) {
        Member checkedMember = this.memberRepository.findByUsername(username);

        if(checkedMember != null) {
            throw new RuntimeException("이미 가입된 사용자입니다.");
        }

        Member member = Member.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .build();
        this.memberRepository.save(member);

        return member;
    }
}
