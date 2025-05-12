package com.kh.board.service;

import com.kh.board.entity.Board;

import java.util.List;

public interface BoardService {
    List<Board> findAll();
    Board findById(Long boardId);
    int deleteById(Long boardId);
    int save(Board board);
    Long update(Board board);
}
