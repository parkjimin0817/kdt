package com.kh.board.service;

import com.kh.board.entity.Board;
import com.kh.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public List<Board> findAll() {return boardMapper.findAll();}

    @Override
    public Board findById(int boardId) {return boardMapper.findById(boardId);}

    @Override
    public void deleteById(int boardId) { boardMapper.deleteById(boardId); }
}
