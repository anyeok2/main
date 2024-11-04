package com.example.anyeok.domain.member.dto.response;

import com.example.anyeok.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MemberResponse {
    private final String username;
    private final LocalDateTime createdDate;

    public MemberResponse(Member member) {
        this.username = member.getUsername();
        this.createdDate = member.getCreatedDate();
    }
}
