package com.example.vue_backboard.controller;

import com.example.vue_backboard.model.Header;
import com.example.vue_backboard.model.SearchCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import com.example.vue_backboard.services.BoardService;
import com.example.vue_backboard.dtos.BoardDto;
import lombok.RequiredArgsConstructor;
import com.example.vue_backboard.entity.BoardEntity;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/board/list")
    public Header<List<BoardDto>> boardList(
            @PageableDefault(sort = {"idx"}) Pageable pageable, SearchCondition searchCondition
    ) {
        return boardService.getBoardList(pageable, searchCondition);
    }

    @GetMapping("/board/{id}")
    public BoardDto getBoard(@PathVariable Long id){
        return boardService.getBoard(id);
    }

    @PostMapping("/board")
    public BoardEntity create(@RequestBody BoardDto boardDto){
        return boardService.create(boardDto);
    }

    @PatchMapping("/board")
    public BoardEntity update(@RequestBody BoardDto boardDto){
        return boardService.update(boardDto);
    }
    @PostMapping("/test")
    public String postTest (){
        return "post테스트요청완료";
    }
}
