package com.kdt.testauth.service;

import com.kdt.testauth.dto.CustomOAuth2User;
import com.kdt.testauth.dto.GoogleResponse;
import com.kdt.testauth.dto.OAuth2Response;
import com.kdt.testauth.dto.UserDto;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationResponse;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        System.out.println(oAuth2User);
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response = null;
        if (registrationId.equals("google") ){
            oAuth2Response = new GoogleResponse( oAuth2User.getAttributes());
        }
        else {
            return null;
        }

        String userName = oAuth2Response.getProvider() + " "+ oAuth2Response.getProviderId();

        UserDto userDto = new UserDto();
        userDto.setName( oAuth2Response.getName() );
        userDto.setUsename(userName);
        userDto.setRole("ROLE_USER");


        return new CustomOAuth2User(userDto);
    }
}
