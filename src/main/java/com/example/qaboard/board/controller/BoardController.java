package com.example.qaboard.board.controller;

import com.example.qaboard.board.dto.BoardDto;
import com.example.qaboard.board.service.BoardService;
import com.example.qaboard.global.security.MyUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String boardList(Model model, @AuthenticationPrincipal MyUserDetails myUserDetails) {
        if (myUserDetails != null) {
            model.addAttribute("memberNumber", myUserDetails.getMemberNumber());
        }
        return "board/list";
    }

    @GetMapping("/read")
    public String boardRead(Integer boardNumber, Model model, @AuthenticationPrincipal MyUserDetails myUserDetails) {
        if(myUserDetails != null){
            model.addAttribute("memberNumber",myUserDetails.getMemberNumber());
        }
        model.addAttribute("board",boardService.read(boardNumber));
        return "board/read";
    }

    @PostMapping("/delete")
    public String boardDelete(Integer boardNumber, Integer boardWriter, @AuthenticationPrincipal MyUserDetails myUserDetails){
        boardService.delete(boardNumber, boardWriter, myUserDetails.getMemberNumber());
        return "redirect:/board/list";
    }

    @GetMapping("/write")
    public String boardWrite(Model model, @AuthenticationPrincipal MyUserDetails myUserDetails) {
        model.addAttribute("memberNumber", myUserDetails.getMemberNumber());
        return "board/write";
    }

    @PostMapping("/write")
    public String boardWrite(BoardDto.Write dto, Model model, RedirectAttributes ra) {
        Boolean result = boardService.write(dto);
        if (!result) {
            ra.addFlashAttribute("Message","작성 실패");
        }
        return "redirect:/board/list";
    }
}
