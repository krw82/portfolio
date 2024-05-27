package com.coin.portfolio.portfolio.Jwt;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.filter.OncePerRequestFilter;

import com.coin.portfolio.portfolio.Auth.Impl.UserDetail;
import com.coin.portfolio.portfolio.Error.ErrorCode;
import com.coin.portfolio.portfolio.Error.PortfolioExeption;
import com.coin.portfolio.portfolio.User.UserRepository;
import com.coin.portfolio.portfolio.User.userEntity;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public JwtAuthFilter(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) { // JWT혹은 OAuth 토큰의 규칙
            String token = authHeader.substring(7);
            if (jwtUtil.validateToken(token)) {
                Long userId = jwtUtil.getUserId(token);
                userEntity user = userRepository.findById(userId.toString())
                        .orElseThrow(() -> new PortfolioExeption(ErrorCode.USER_NOT_FOUND));
                UserDetail userDetail = new UserDetail(user);
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetail,
                        null, userDetail.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else {
                System.out.println("asdasdasdasdsad");
                request.setAttribute("exception", ErrorCode.INVALID_PASSWORD.getErrCode());
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                return;

            }
        } else {
            System.out.println("asdasdasdasds22222222ad");
            request.setAttribute("exception", ErrorCode.USER_NOT_FOUND.getErrCode());
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;

        }
        filterChain.doFilter(request, response);
    }

}
