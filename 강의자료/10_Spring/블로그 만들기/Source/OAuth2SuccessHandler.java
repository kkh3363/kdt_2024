package com.kdt.myblog.config.oauth;

import com.kdt.myblog.config.jwt.TokenProvider;
import com.kdt.myblog.domain.RefreshToken;
import com.kdt.myblog.domain.User;
import com.kdt.myblog.repository.RefreshTokenRepository;
import com.kdt.myblog.service.UserService;
import com.kdt.myblog.util.CookieUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.time.Duration;

@RequiredArgsConstructor
@Component
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    public static final String REFRESH_TOKEN_COOKIE_NAME = "refresh_token";
    public static final Duration REPRESH_TOKEN_DURATION = Duration.ofDays(14);
    public static final Duration ACCESS_TOKEN_DURATION = Duration.ofDays(1);
    public static final String REDIRECT_PATH = "/articles";

    private  final TokenProvider tokenProvider;
    private  final RefreshTokenRepository refreshTokenRepository;
    private final OAuth2AuthorizationRequestBasedOnCookieRepository authorizationRequestRepository;
    private final UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2User oAuth2User = (OAuth2User)authentication.getPrincipal();
        User user = userService.findByEmail( (String)oAuth2User.getAttributes().get("email"));

        // 1. 리프레시 토큰 생성 -> 저장 -> 쿠키로 저장
        String refreshToken = tokenProvider.generateToken( user, REPRESH_TOKEN_DURATION);
        saveRefreshToken( user.getId(), refreshToken);
        addRefreshTokenToCookie(request, response, refreshToken);
        // 2. Access 토큰 생성 -> 패스에 엑세스 토큰 추가
        String accessToken = tokenProvider.generateToken( user, ACCESS_TOKEN_DURATION);
        String targetUrl = getTargetUrl(accessToken);
        // 3. 인증 관련 설정값, 쿠키 제거
        clearAuthenticationAttributes(request, response);
        // 4. 리다리레션
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }


    private void clearAuthenticationAttributes(HttpServletRequest request, HttpServletResponse response){
        super.clearAuthenticationAttributes(request);
        authorizationRequestRepository.removeAuthorizationRequestCookie(request, response);

    }
    private String getTargetUrl(String token){
        return UriComponentsBuilder.fromUriString(REDIRECT_PATH)
                .queryParam("token", token)
                .build()
                .toUriString();
    }

    // 생성된 리프레시 토큰을 잔달 받아서 DB에 저장
    private void saveRefreshToken(Long userId, String newRefreshToken){
        RefreshToken refreshToken = refreshTokenRepository.findByUserId(userId)
                .map(entity->entity.update(newRefreshToken))
                .orElse(new RefreshToken(userId, newRefreshToken));

        refreshTokenRepository.save(refreshToken);
    }

    private void addRefreshTokenToCookie( HttpServletRequest request, HttpServletResponse response, String refreshToken){
        int cookieMaxAge =  (int)REPRESH_TOKEN_DURATION.toSeconds();

        CookieUtil.deleteCookie( request, response, REFRESH_TOKEN_COOKIE_NAME);
        CookieUtil.addCookie( response, REFRESH_TOKEN_COOKIE_NAME, refreshToken, cookieMaxAge);
    }
}
