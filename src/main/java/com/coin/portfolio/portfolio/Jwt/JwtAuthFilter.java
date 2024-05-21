package com.coin.portfolio.portfolio.Jwt;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.coin.portfolio.portfolio.Auth.Impl.UserDetail;
import com.coin.portfolio.portfolio.Error.ErrorCode;
import com.coin.portfolio.portfolio.Error.PortfolioExeption;
import com.coin.portfolio.portfolio.User.User;
import com.coin.portfolio.portfolio.User.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) { // JWT혹은 OAuth 토큰의 규칙
            String token = authHeader.substring(7);
            if (jwtUtil.validateToken(token)) {
                Long userId = jwtUtil.getUserId(token);
                User user = userRepository.findById(userId.toString())
                        .orElseThrow(() -> new PortfolioExeption(ErrorCode.USER_NOT_FOUND));
                UserDetail userDetail = new UserDetail(user);
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetail,
                        null, userDetail.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }

}
