package com.example.qaboard.member;

import com.example.qaboard.member.dao.MemberDao;
import com.example.qaboard.member.dto.MemberDto;
import com.example.qaboard.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberDao memberDao;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Boolean join(MemberDto.Join dto) {
        Member member = dto.toEntity(passwordEncoder.encode(dto.getMemberPassword()));
        return memberDao.join(member)>=1;
    }

   // public Boolean duplicateCheck(MemberDto.Duplicate dto) {


   // }


}
