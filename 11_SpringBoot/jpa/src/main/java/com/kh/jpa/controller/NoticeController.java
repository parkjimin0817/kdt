package com.kh.jpa.controller;

import com.kh.jpa.dto.MemberDto;
import com.kh.jpa.dto.NoticeDto;
import com.kh.jpa.entity.Member;
import com.kh.jpa.repository.MemberRepository;
import com.kh.jpa.service.MemberService;
import com.kh.jpa.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notices")
@RequiredArgsConstructor
public class NoticeController {

    public final NoticeService noticeService;
    public final MemberRepository memberRepository;

    //공지사항 등록
    @PostMapping
    public ResponseEntity<Long> addNotice(@RequestBody NoticeDto.Create createDto,  @RequestParam String userId){
        Member member = memberRepository.findOne(userId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자입니다."));
        Long noticeNo = noticeService.createNotice(createDto, member);
        return ResponseEntity.ok(noticeNo);
    }

    //공지사항 조회
    @GetMapping("/{noticeNo}")
    public ResponseEntity<NoticeDto.Response> getNotice(@PathVariable Long noticeNo){
        return ResponseEntity.ok(noticeService.findNotice(noticeNo));
    }

    //공지사항 수정
    @PutMapping("/{noticeNo}")
    public ResponseEntity<NoticeDto.Response> updateNotice(
            @PathVariable Long noticeNo,
            @RequestBody NoticeDto.Update updateDto){
        return ResponseEntity.ok(noticeService.updateNotice(noticeNo, updateDto));
    }

    //공지사항 삭제
    @DeleteMapping("/{noticeNo}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Long noticeNo){
        noticeService.deleteNotice(noticeNo);
        return ResponseEntity.ok().build();
    }

    //제목키워드로 검색
    @GetMapping("/search/title")
    public ResponseEntity<List<NoticeDto.Response>> searchNoticeByTitle(@RequestParam String title){
        return ResponseEntity.ok(noticeService.findByTitle(title));
    }

}
