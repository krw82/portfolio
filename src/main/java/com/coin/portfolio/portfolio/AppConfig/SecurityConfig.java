package com.coin.portfolio.portfolio.AppConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.coin.portfolio.portfolio.Jwt.JwtAuthFilter;
import com.coin.portfolio.portfolio.Jwt.JwtUtil;
import com.coin.portfolio.portfolio.User.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

        private final UserRepository userRepository;
        private final JwtUtil jwtUtil;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .csrf(csrf -> csrf.disable()) // CSRF 보호 비활성화

                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers("/api/auth/**", "/h2-console/**", "/login")
                                                .permitAll() // 인증 없이 접근 허용
                                                .anyRequest().authenticated() // 나머지 요청은 인증된 사용자만 접근 허용
                                )

                                .formLogin(login -> login.disable())

                                .logout(logout -> logout
                                                .logoutUrl("/logout") // 로그아웃 URL 설정
                                                .logoutSuccessUrl("/login?logout") // 로그아웃 성공 시 리다이렉트할 URL 설정
                                                .permitAll() // 로그아웃 URL은 모두 접근 허용
                                )
                                .headers(headers -> headers
                                                .frameOptions(frameOptions -> frameOptions.sameOrigin()) // H2 콘솔 사용을 위해
                                                                                                         // frame 옵션 설정
                                )
                                .cors(Customizer.withDefaults())
                                .sessionManagement(sessionManagement -> sessionManagement
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                                .addFilterBefore(new JwtAuthFilter(userRepository, jwtUtil),
                                                UsernamePasswordAuthenticationFilter.class);

                return http.build(); // HttpSecurity 설정을 빌드하여 SecurityFilterChain 반환
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

}
