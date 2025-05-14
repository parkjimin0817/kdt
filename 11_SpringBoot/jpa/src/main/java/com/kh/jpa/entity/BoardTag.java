package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "board_tag")
@Getter
public class BoardTag {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_no")
    private Board board;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;
}
