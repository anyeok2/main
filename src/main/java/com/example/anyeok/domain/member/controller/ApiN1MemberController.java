package com.example.anyeok.domain.member.controller;

import com.example.anyeok.domain.member.dto.request.MemberRequest;
import com.example.anyeok.domain.member.dto.response.MemberResponse;
import com.example.anyeok.domain.member.entity.Member;
import com.example.anyeok.domain.member.service.MemberService;
import com.example.anyeok.global.rsdata.RsData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/members")
@RequiredArgsConstructor
public class ApiN1MemberController {
    private final MemberService memberService;

    @PostMapping("/join")
    public RsData<MemberResponse> join (@Valid @RequestBody MemberRequest memberRequest) {
        Member member = this.memberService.join(memberRequest.getUsername(), memberRequest.getPassword());
        return RsData.of("200", "회원가입이 완료되었습니다.", new MemberResponse(member));
    }
}
