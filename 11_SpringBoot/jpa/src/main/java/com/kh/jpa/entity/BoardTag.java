package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "BOARD_TAG")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class BoardTag {

    @Id
    @Column(name = "BOARD_TAG_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardTagId;

    //Board : 중계테이블 (1 : N)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_NO", nullable = false)
    private Board board;

    //Tag : 중계테이블 (1 : N)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TAG_ID", nullable = false)
    private Tag tag;
}
