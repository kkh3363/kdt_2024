package com.kdt.testauth.jwt;

import com.kdt.testauth.dto.CustomOAuth2User;
import com.kdt.testauth.dto.UserDto;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JWTFilter extends OncePerRequestFilter {
    private final JWTUtil jwtUtil;

    public JWTFilter( JWTUtil jwtUtil){
        this.jwtUtil = jwtUtil;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 쿠키들을 불러온 후에  Authorization key 쿠키를 찾기
        String authorization = null;
        Cookie[] cookies = request.getCookies();

        for( Cookie cookie : cookies){
            if ( cookie.getName().equals("Authorization")){
                authorization =  cookie.getValue();
            }
        }
        // Authorization 헤더 검증
        if ( authorization == null ){
            System.out.println("Not found Token");
            filterChain.doFilter(request, response);
            return;
        }
        // 토큰
        String token = authorization;
        if (jwtUtil.isExpired(token) ){
            System.out.println("Token Expired");
            filterChain.doFilter(request, response);
            return;
        }
        // 토큰에서 username, role
        String userName = jwtUtil.getUsername(token);
        String role = jwtUtil.getRole(token);

        // userDTO를 생성해 값 설정
        UserDto userDto = new UserDto();
        userDto.setUsename( userName);
        userDto.setRole(role);
        // userDeatils에 회원 정보 객체 담기
        CustomOAuth2User customOAuth2User = new CustomOAuth2User(userDto);

        // 스프링 시큐리티 인증 토큰 생성
        Authentication authToken = new UsernamePasswordAuthenticationToken( customOAuth2User, null, customOAuth2User.getAuthorities());
        // 세션에 사용자 등록
        SecurityContextHolder.getContext().setAuthentication( authToken );
        filterChain.doFilter(request, response);
    }
}
