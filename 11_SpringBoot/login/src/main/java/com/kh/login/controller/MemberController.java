package com.kh.login.controller;

import com.kh.login.auth.JwtTokenProvider;
import com.kh.login.domain.Member;
import com.kh.login.dto.MemberCreateDto;
import com.kh.login.dto.MemberLoginDto;
import com.kh.login.dto.MemberResponseDto;
import com.kh.login.service.MemberService;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody MemberCreateDto memberCreateDto) {
        Member member = memberService.create(memberCreateDto);
        return new ResponseEntity<>(member.getId(), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody MemberLoginDto memberLoginDto) {
        Member member = memberService.login(memberLoginDto);

        String jwtToken = jwtTokenProvider.createToken(member.getEmail(), member.getRole());
        Map<String, Object> loginInfo = new HashMap<>();
        loginInfo.put("token", jwtToken);
        return new ResponseEntity<>(loginInfo, HttpStatus.OK);
    }

    @GetMapping("/me")
    public ResponseEntity<?> getMemberInfo() {
        //jwt토큰에서 이메일 추출
        String email = jwtTokenProvider.getUserEmailFromToken();
        MemberResponseDto memberInfo = memberService.getMemberInfoByEmail(email);
        return new ResponseEntity<>(memberInfo, HttpStatus.OK);
    }
}