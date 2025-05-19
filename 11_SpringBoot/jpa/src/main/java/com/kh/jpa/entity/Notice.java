package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTICE_NO")
    private Long noticeNo;

    @Column(name = "NOTICE_TITLE", length = 30, nullable = false)
    private String noticeTitle;

    @Column(name = "NOTICE_CONTENT", length = 200, nullable = false)
    private String noticeContent;

    @Column(name = "CREATE_DATE", updatable = false)
    private LocalDateTime createDate;

    public void updateNotice(String noticeTitle, String noticeContent) {
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
    }

    //Notice : Member (N : 1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NOTICE_WRITER")
    private Member member;

    @PrePersist
    public void prePersist(){
        this.createDate = LocalDateTime.now();
    }

}
