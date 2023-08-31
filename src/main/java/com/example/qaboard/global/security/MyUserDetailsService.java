package com.example.qaboard.global.security;

import com.example.qaboard.member.dao.MemberDao;
import com.example.qaboard.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {
    private final MemberDao memberDao;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.equals("admin")) {
            return new MyUserDetails(0, username, passwordEncoder.encode("1234"), "관리자", true,List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));
        }
        try {
            Member member = memberDao.findByUsername(username);
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new MyUserDetails(member.getMemberNumber(),username, member.getMemberPassword(),  member.getMemberNickname(), true, authorities);

        }catch (NoSuchElementException e) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다");
        }
    }
}
