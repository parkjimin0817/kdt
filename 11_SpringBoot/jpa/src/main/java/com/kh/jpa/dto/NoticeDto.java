package com.kh.jpa.dto;

import com.kh.jpa.entity.Member;
import com.kh.jpa.entity.Notice;
import lombok.*;

import java.time.LocalDateTime;

public class NoticeDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private String notice_title;
        private String notice_content;
        private LocalDateTime create_date;
        private String notice_writer;

        public Notice toEntity(Member member){
            return Notice.builder()
                    .noticeTitle(this.notice_title)
                    .noticeContent(this.notice_content)
                    .createDate(this.create_date)
                    .member(member)
                    .build();
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update {
        private String notice_title;
        private String notice_content;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response {
        private Long notice_no;
        private String notice_title;
        private String notice_content;
        private LocalDateTime create_date;
        private String notice_writer;

        public static Response toDto(Notice notice) {
            return Response.builder()
                    .notice_no(notice.getNoticeNo())
                    .notice_title(notice.getNoticeTitle())
                    .notice_content(notice.getNoticeContent())
                    .create_date(notice.getCreateDate())
                    .notice_writer(notice.getMember().getUserId())
                    .build();
        }
    }
}
