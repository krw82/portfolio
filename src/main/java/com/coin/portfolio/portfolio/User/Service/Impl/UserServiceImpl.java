package com.coin.portfolio.portfolio.User.Service.Impl;

import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.coin.portfolio.portfolio.Error.ErrorCode;
import com.coin.portfolio.portfolio.Error.PortfolioExeption;
import com.coin.portfolio.portfolio.User.UserRepository;
import com.coin.portfolio.portfolio.User.userEntity;
import com.coin.portfolio.portfolio.User.Service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public userEntity login(Map<String, String> params) {
        userEntity user = userRepository.findById(params.get("Id"))
                .orElseThrow(() -> new PortfolioExeption(ErrorCode.USER_NOT_FOUND));
        return user;
    }

}
