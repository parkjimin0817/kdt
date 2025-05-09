package com.kh.board.service;

import com.kh.board.entity.Board;

import java.util.List;

public interface BoardService {
    List<Board> findAll();
    Board findById(int boardId);
    void deleteById(int boardId);
}
