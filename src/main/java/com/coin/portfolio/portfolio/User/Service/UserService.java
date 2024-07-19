package com.coin.portfolio.portfolio.User.Service;

import java.util.List;
import java.util.Map;

import com.coin.portfolio.portfolio.DTO.UserDto;
import com.coin.portfolio.portfolio.Entity.UserEntity;

public interface UserService {
    public UserDto login(Map<String, String> params);

    UserDto getUserById(String id);

    UserDto createUser(UserEntity user);

    void deleteUser(String id);
}
