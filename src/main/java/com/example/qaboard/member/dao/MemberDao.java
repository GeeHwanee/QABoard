package com.example.qaboard.member.dao;

import com.example.qaboard.member.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    public Integer join(Member member);

    public Member findByUsername(String username);
}
