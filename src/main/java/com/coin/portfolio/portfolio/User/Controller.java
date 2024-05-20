package com.coin.portfolio.portfolio.User;

import org.springframework.web.bind.annotation.RestController;

import com.coin.portfolio.portfolio.User.Service.UserService;

import lombok.RequiredArgsConstructor;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor

public class Controller {

    private final UserService userService;

    @PostMapping("/api/auth/login")
    public String login(@RequestBody Map<String, String> params) {
        userService.login(params);
        return "";
    }
}
