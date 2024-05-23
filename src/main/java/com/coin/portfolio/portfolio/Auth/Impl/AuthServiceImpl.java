package com.coin.portfolio.portfolio.Auth.Impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.coin.portfolio.portfolio.AppConfig.SecurityConfig;
import com.coin.portfolio.portfolio.Auth.AuthService;
import com.coin.portfolio.portfolio.Error.ErrorCode;
import com.coin.portfolio.portfolio.Error.PortfolioExeption;
import com.coin.portfolio.portfolio.Jwt.JwtUtil;
import com.coin.portfolio.portfolio.User.User;
import com.coin.portfolio.portfolio.User.UserRepository;

import lombok.RequiredArgsConstructor;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
@Primary
public class AuthServiceImpl implements AuthService {

    private final JwtUtil jwtUtil;
    private final UserRepository UserRepository;
    private final SecurityConfig securityConfig;

    @Override
    public String login(HashMap<String, Object> param) {
        String id = (String) param.get("id");
        String password = (String) param.get("password");
        User userEntity = UserRepository.findById(id)
                .orElseThrow(() -> new PortfolioExeption(ErrorCode.USER_NOT_FOUND));

        // if (!securityConfig.passwordEncoder().matches(password,
        // userEntity.getPassword())) {
        if (!password.equals(userEntity.getPassword())) {

            // 비밀번호 체크
            throw new PortfolioExeption(ErrorCode.INVALID_PASSWORD);
        }

        return jwtUtil.createAccesToken(userEntity);
        // 토큰발행
    }

}
