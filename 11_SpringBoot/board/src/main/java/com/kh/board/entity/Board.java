package com.kh.board.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    private Long boardId;
    private String title;
    private String contents;
    private String fileName;
    private String memberEmail;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //변경이 필요한 부분만 setter를 작성해준다.
    public void changeFileName (String fileName) { this.fileName = fileName; }
}
