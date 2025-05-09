package com.kh.board.controller;

import com.kh.board.controller.dto.response.BoardResponse;
import com.kh.board.entity.Board;
import com.kh.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    //게시글 목록 가져오는 api
    @GetMapping
    public ResponseEntity<List<BoardResponse.SimpleDTO>> getBoardList() {
        List<Board> boardList = boardService.findAll();

        List<BoardResponse.SimpleDTO> result = new ArrayList<>();
        for (Board board : boardList) {
            result.add(BoardResponse.SimpleDTO.formEntity(board));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //게시글 상세 가져오는 api
    @GetMapping("/{boardId}")
    public ResponseEntity<BoardResponse.DetailDTO> getBoard(@PathVariable int boardId) {
        Board board = boardService.findById(boardId);
        BoardResponse.DetailDTO result = BoardResponse.DetailDTO.formEntity(board);
        System.out.println(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<Void> deleteBoard(@PathVariable int boardId) {
        boardService.deleteById(boardId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
