package com.coin.portfolio.portfolio.AppConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .csrf(csrf -> csrf.disable()) // CSRF 보호 비활성화

                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers("/api/auth/**").permitAll() // "/api/auth/**" 경로는 인증 없이
                                                                                             // 접근 허용
                                                .anyRequest().authenticated() // 나머지 요청은 인증된 사용자만 접근 허용
                                )
                                .formLogin(form -> form
                                                .loginPage("/login") // 커스텀 로그인 페이지 설정
                                                .defaultSuccessUrl("/", true) // 로그인 성공 시 리다이렉트할 기본 URL 설정
                                                .permitAll() // 로그인 페이지는 모두 접근 허용
                                )
                                .logout(logout -> logout
                                                .logoutUrl("/logout") // 로그아웃 URL 설정
                                                .logoutSuccessUrl("/login?logout") // 로그아웃 성공 시 리다이렉트할 URL 설정
                                                .permitAll() // 로그아웃 URL은 모두 접근 허용
                                );

                return http.build(); // HttpSecurity 설정을 빌드하여 SecurityFilterChain 반환
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

}
