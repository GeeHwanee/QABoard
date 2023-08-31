package com.example.qaboard.member.dto;

import com.example.qaboard.member.entity.Member;
import lombok.Data;

public class MemberDto {

    @Data
    public static class Duplicate{
        private String memberId;
        private String memberNickname;
    }
    @Data
    public static class Join{
        private String memberId;
        private String memberPassword;
        private String memberNickname;

        public Member toEntity(String encodedPassword) {
            return Member.builder().memberId(memberId).memberPassword(encodedPassword).memberNickname(memberNickname).build();
        }
    }
}
