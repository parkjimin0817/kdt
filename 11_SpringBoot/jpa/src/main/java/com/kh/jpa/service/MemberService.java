package com.kh.jpa.service;

import com.kh.jpa.dto.MemberDto;
import com.kh.jpa.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MemberService {
    String createMember(MemberDto.Create creatDto);
    MemberDto.Response findMember(String userId);
    List<MemberDto.Response> findAllMember();
    MemberDto.Response updateMember(String userId, MemberDto.Update updateDto);
    void deleteMember(String userId);
    List<MemberDto.Response> findByName(String name);
}
