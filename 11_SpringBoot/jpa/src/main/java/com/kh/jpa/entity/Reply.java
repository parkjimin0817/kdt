package com.kh.jpa.entity;

import com.kh.jpa.enums.CommonEnums;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPLY_NO")
    private Long replyNo;

    @Column(name = "REPLY_CONTENT", length = 400, nullable = false)
    private String replyContent;

    @Column(name = "CREATE_DATE", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "STATUS", length = 1, nullable = false)
    @Enumerated(EnumType.STRING)
    private CommonEnums.Status status;

    //어떤 게시글의 댓글인지 게시글 정보
    //댓글 : 게시글 (N : 1)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "REF_BNO")
    private Board board;

    //어떤 사람의 댓글인지 작성자 정보
    //댓글 : 작성자 (N : 1)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "REPLY_WRITER")
    private Member member;

    @PrePersist
    public void prePersist() {
        this.createDate = LocalDateTime.now();
        if (this.status == null) {
            this.status = CommonEnums.Status.Y;
        }
    }
}
