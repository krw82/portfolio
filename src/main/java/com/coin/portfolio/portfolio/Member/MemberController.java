package com.coin.portfolio.portfolio.Member;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coin.portfolio.portfolio.ApiResponse.ApiResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class MemberController {
    @GetMapping("/login22")
    public ApiResponse<String> login2(@RequestBody HashMap<String, Object> param) {

        return new ApiResponse<>(HttpStatus.OK.value(), "", "dfdf");

    }

}
