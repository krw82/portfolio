package com.coin.portfolio.portfolio.Jwt;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.filter.OncePerRequestFilter;

import com.coin.portfolio.portfolio.Auth.Impl.UserDetail;
import com.coin.portfolio.portfolio.Error.ErrorCode;
import com.coin.portfolio.portfolio.Error.PortfolioExeption;
import com.coin.portfolio.portfolio.User.UserEntity;
import com.coin.portfolio.portfolio.User.UserRepository;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    public JwtAuthFilter(UserRepository userRepository, JwtUtil jwtUtil,
            CustomAuthenticationEntryPoint customAuthenticationEntryPoint) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.customAuthenticationEntryPoint = customAuthenticationEntryPoint;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            if (jwtUtil.validateToken(token)) { // 토큰 활성화 여부

                String userId = jwtUtil.getUserId(token);
                UserEntity user = userRepository.findById(userId.toString()) // 해당 토큰의 아이디를 얻어 아이디가 존재하는지 여부
                        .orElseThrow(() -> new PortfolioExeption(ErrorCode.USER_NOT_FOUND));
                UserDetail userDetail = new UserDetail(user);
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetail,
                        null, userDetail.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authToken);

            } else {
                // 토큰이 유효하지 않으면 401 응답을 반환
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                // response.getWriter().write("Unauthorized: Invalid JWT token");
                return;
            }

        }
        filterChain.doFilter(request, response);
    }

}
