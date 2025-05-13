package com.kh.board.controller.dto.response;

import com.kh.board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BoardResponse {

    @Getter
    @Setter
    @Builder
    public static class SimpleDTO{
        private Long board_id;
        private String member_email;
        private String title;
        private LocalDateTime created_at;

        public static SimpleDTO formEntity(Board board){
            return SimpleDTO.builder()
                    .board_id(board.getBoardId())
                    .member_email(board.getMember().getEmail())
                    .title(board.getTitle())
                    .created_at(board.getCreatedAt())
                    .build();
        }
    }

    @Getter
    @Setter
    @Builder
    public static class DetailDTO{
        private Long board_id;
        private String title;
        private String member_email;
        private String contents;
        public String file_name;

        public static DetailDTO formEntity(Board board){
            return DetailDTO.builder()
                    .board_id(board.getBoardId())
                    .title(board.getTitle())
                    .member_email(board.getMember().getEmail())
                    .contents(board.getContents())
                    .file_name(board.getFileName())
                    .build();
        }

    }
}
