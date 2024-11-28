package com.kdt.testauth.config.oauth2;

import com.kdt.testauth.dto.CustomOAuth2User;
import com.kdt.testauth.jwt.JWTUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

@RequiredArgsConstructor
@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JWTUtil jwtUtil;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request
            , HttpServletResponse response
            , Authentication authentication) throws IOException, ServletException {
        CustomOAuth2User customOAuth2User = (CustomOAuth2User)authentication.getPrincipal();

        String userName = customOAuth2User.getUsername();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> interator = authorities.iterator();
        GrantedAuthority auth = interator.next();
        String role = auth.getAuthority();
        String token = jwtUtil.createJwt( userName, role,   60*60*60L);

        response.addCookie( createCookie("Authorization", token) );
        response.sendRedirect("http://localhost:8080/");
    }

    private Cookie createCookie(String key, String value){
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge( 60*60*60 );
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        return cookie;
    }
}



