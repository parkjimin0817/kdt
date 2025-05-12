package com.kh.board.mapper;

import com.kh.board.entity.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> findAll();
    Board findById(@Param("boardId") Long boardId);
    int deleteById(@Param("boardId") Long boardId);
    int save(Board board);
    int update(Board board);
}