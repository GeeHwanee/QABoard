package com.example.qaboard.board.controller;

import com.example.qaboard.board.dto.BoardDto;
import com.example.qaboard.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
public class BoardRestController {

    private final BoardService boardService;

    @GetMapping("/preview")
    public ResponseEntity<BoardDto.PreviewPage> preview(@DefaultValue(value = "1") Integer pageNumber){
        return ResponseEntity.ok(boardService.preview(pageNumber));
    }

    @PostMapping("/update")
    public ResponseEntity<Boolean> update(String boardTitle, String boardContent, Integer boardNumber){
        System.out.println(boardTitle);
        System.out.println(boardContent);
        System.out.println(boardNumber);
        return ResponseEntity.ok(boardService.update(boardTitle,boardContent, boardNumber));
    }
}
