package com.example.qaboard;

import com.example.qaboard.member.dao.MemberDao;
import com.example.qaboard.member.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Watchable;

@SpringBootTest
class QaBoardApplicationTests {
    @Autowired
    MemberDao memberDao;

    @Test
    void contextLoads() {
        Member member = Member.builder().memberId("ss").memberPassword("ss").memberNickname("ss").build();
        memberDao.join(member);
    }

}
