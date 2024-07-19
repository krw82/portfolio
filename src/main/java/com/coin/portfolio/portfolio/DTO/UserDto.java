package com.coin.portfolio.portfolio.DTO;

import com.coin.portfolio.portfolio.User.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String id;
    private String userName;
    private UserRole role;
}