package com.coin.portfolio.portfolio.Auth.Impl;

import org.springframework.stereotype.Service;

import com.coin.portfolio.portfolio.Auth.AuthService;
import com.coin.portfolio.portfolio.Jwt.JwtUtil;
import com.coin.portfolio.portfolio.User.User;
import com.coin.portfolio.portfolio.User.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtUtil jwtUtil;
    private final UserRepository UserRepository;

    @Override
    public String login(User userDto) {
        String id = userDto.getId();
        String password = userDto.getPassword();
        User userEntity = UserRepository.getReferenceById(id);

        if (id == null) {
            // Execption
        }
        // 인코딩 비밀번호 관련 확인해야함.

        return jwtUtil.createAccesToken(userDto);
        // 토큰발행
    }

}
