package com.coin.portfolio.portfolio.User.Service;

import java.util.Map;

import com.coin.portfolio.portfolio.User.userEntity;

public interface UserService {
    public userEntity login(Map<String, String> params);
}
