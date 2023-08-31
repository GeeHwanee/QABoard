package com.example.qaboard.member.cotroller;

import com.example.qaboard.member.MemberService;
import com.example.qaboard.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/member")
public class MemberRestController {

    private final MemberService memberService;
/*
    @GetMapping("/duplicate")
    public ResponseEntity<?> duplicateCheck(MemberDto.Duplicate dto){
       Boolean result = memberService.duplicateCheck(dto);
       if(!result){
           return ResponseEntity.status(HttpStatus.CONFLICT).body("중복");
       }else {
           return ResponseEntity.ok("성공");
       }
    }*/

}
