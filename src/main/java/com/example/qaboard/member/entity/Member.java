package com.example.qaboard.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
public class Member {

    private Integer memberNumber;
    private String memberId;
    private String memberPassword;
    private String memberNickname;

}
