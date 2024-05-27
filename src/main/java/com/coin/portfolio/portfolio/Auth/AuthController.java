package com.coin.portfolio.portfolio.Auth;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coin.portfolio.portfolio.ApiResponse.ApiResponse;

import lombok.RequiredArgsConstructor;
import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ApiResponse<String> login(@RequestBody HashMap<String, Object> param) {
        // String token = authService.login(param);
        System.out.println("asdasdsadsad");
        return new ApiResponse<>(HttpStatus.OK.value(), "", "");
    }

}
