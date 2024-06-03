package com.coin.portfolio.portfolio.Jwt;

import java.security.Key;
import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.coin.portfolio.portfolio.User.UserEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtUtil {

    private final Key key;
    private final long accessTokenExpTime;

    public JwtUtil(@Value("${jwt.secret}") String secretKey, @Value("${jwt.expiration_time}") long accessTokenExpTime) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
        this.accessTokenExpTime = accessTokenExpTime;
    }

    public String createAccesToken(UserEntity user) {
        return createToken(user, accessTokenExpTime);
    }

    private String createToken(UserEntity user, long expireTime) {
        Claims claims = Jwts.claims(); /// 토큰에 들어갈 값(body)
        claims.put("id", user.getId());
        claims.put("userName", user.getUserName());
        claims.put("role", user.getRole());

        ZonedDateTime now = ZonedDateTime.now(); // 토큰 활성화시간
        ZonedDateTime tokenValidTime = now.plusSeconds(expireTime); // 토큰끝나는 시간

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(Date.from(now.toInstant()))
                .setExpiration(Date.from(tokenValidTime.toInstant()))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUserId(String token) {
        return paseClaims(token).get("id", String.class);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("Invalid JWT Token", e);
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT Token", e);
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT Token", e);
        } catch (IllegalArgumentException e) {
            log.info("JWT claims string is empty.", e);
        }
        return false;

    }

    public Claims paseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody(); // ?
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

}
