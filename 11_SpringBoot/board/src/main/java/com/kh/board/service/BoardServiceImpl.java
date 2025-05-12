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
    public Board findById(Long boardId) {return boardMapper.findById(boardId);}

    @Override
    public int deleteById(Long boardId) { return boardMapper.deleteById(boardId);}

    @Override
    public int save(Board board) {return boardMapper.save(board);}

    @Override
    public Long update(Board board) {
        boardMapper.update(board);
        return board.getBoardId();
    }
}
