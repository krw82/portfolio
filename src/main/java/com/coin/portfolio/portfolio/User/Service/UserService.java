package com.coin.portfolio.portfolio.User.Service;

import java.util.Map;

import com.coin.portfolio.portfolio.User.User;

public interface UserService {
    public User login(Map<String, String> params);
}
