package com.kh.jpa.service;

import com.kh.jpa.dto.NoticeDto;
import com.kh.jpa.entity.Member;
import com.kh.jpa.entity.Notice;
import com.kh.jpa.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;


    @Override
    public Long createNotice(NoticeDto.Create createDto, Member member) {
        Notice notice = createDto.toEntity(member);
        noticeRepository.save(notice);
        return notice.getNoticeNo();

    }

    @Override
    @Transactional(readOnly = true)
    public NoticeDto.Response findNotice(Long noticeNo) {
        return noticeRepository.findOne(noticeNo)
                .map(NoticeDto.Response::toDto)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 공지사항입니다."));
    }

    @Override
    public NoticeDto.Response updateNotice(Long noticeNo, NoticeDto.Update updateDto) {
        Notice notice = noticeRepository.findOne(noticeNo)
                                        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 공지사항입니다."));
        notice.updateNotice(
                updateDto.getNotice_content(),
                updateDto.getNotice_title()
        );

        return NoticeDto.Response.toDto(notice);
    }

    @Override
    public void deleteNotice(Long noticeNo) {
        Notice notice = noticeRepository.findOne(noticeNo)
                                        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 공지사항입니다."));
        noticeRepository.delete(notice);

    }

    @Override
    public List<NoticeDto.Response> findByTitle(String title) {
        return noticeRepository.findByTitle(title).stream()
                .map(NoticeDto.Response::toDto)
                .collect(Collectors.toList());
    }
}
