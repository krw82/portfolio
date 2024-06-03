package com.coin.portfolio.portfolio.User.Service;

import java.util.Map;

import com.coin.portfolio.portfolio.User.UserEntity;

public interface UserService {
    public UserEntity login(Map<String, String> params);
}
