package com.coin.portfolio.portfolio.Jwt;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.coin.portfolio.portfolio.Error.ErrorCode;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {

        int exception = (int) request.getAttribute("exception");
        System.out.println(exception);
        if (exception == ErrorCode.INVALID_PASSWORD.getErrCode()) {
            setResponse(response, ErrorCode.INVALID_PASSWORD);
        } else if (exception == ErrorCode.USER_NOT_FOUND.getErrCode()) {
            System.out.println("USER_NOT_FOUND");
            setResponse(response, ErrorCode.USER_NOT_FOUND);
        }

    }

    private void setResponse(HttpServletResponse response, ErrorCode code) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        JSONObject responseJson = new JSONObject();
        try {
            responseJson.put("message", code.getMessage());
            responseJson.put("code", code.getErrCode());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        response.getWriter().print(responseJson);
    }

}
