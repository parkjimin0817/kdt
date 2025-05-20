package com.kh.jpa.service;

import com.kh.jpa.dto.BoardDto;
import com.kh.jpa.entity.Board;
import com.kh.jpa.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;

public interface BoardService {
    Page<BoardDto.Response> getBoardList(Pageable pageable);
    BoardDto.Response getBoardDetail(Long boardNo);
    void deleteBoard(Long boardNo);
    Long createBoard(BoardDto.Create createBoard) throws IOException;
}
