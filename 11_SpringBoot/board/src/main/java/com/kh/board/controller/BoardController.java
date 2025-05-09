package com.kh.board.controller;

import org.springframework.context.annotation.Conditional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {
    //게시글 목록 가져오는 api
    @GetMapping
    public String getBoardList() {
        return null;
    }
}
