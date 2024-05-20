package com.coin.portfolio.portfolio.User.Service.Impl;

import java.util.Map;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.coin.portfolio.portfolio.Error.ErrorCode;
import com.coin.portfolio.portfolio.Error.PortfolioExeption;
import com.coin.portfolio.portfolio.User.User;
import com.coin.portfolio.portfolio.User.UserRepository;
import com.coin.portfolio.portfolio.User.Service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User login(Map<String, String> params) {
        Optional<User> opUser = userRepository.findById(params.get("Id"));
        User user = opUser.map(u -> u).orElseThrow(() -> new PortfolioExeption(ErrorCode.USER_NOT_FOUND));
        return user;
    }

}
