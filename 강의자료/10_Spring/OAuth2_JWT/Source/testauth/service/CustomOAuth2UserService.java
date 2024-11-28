package com.kdt.testauth.service;

import com.kdt.testauth.dto.*;
import com.kdt.testauth.entity.UserEntity;
import com.kdt.testauth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationResponse;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        System.out.println(oAuth2User);
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response = null;
        if (registrationId.equals("google") ){
            oAuth2Response = new GoogleResponse( oAuth2User.getAttributes());
        }
        else if ( registrationId.equals("naver")) {
            oAuth2Response = new NaverResponse( (Map)oAuth2User.getAttributes().get("response"));
        }
        else {
            return null;
        }

        String userName = oAuth2Response.getProvider() + " "+ oAuth2Response.getProviderId();
        UserEntity existUser = userRepository.findByUsername(userName );
        if ( existUser == null){
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(userName);
            userEntity.setEmail(oAuth2Response.getEmail());
            userEntity.setName(oAuth2Response.getName());
            userEntity.setRole("ROLE_USER");
            userRepository.save(userEntity);

            UserDto userDto = new UserDto();
            userDto.setName( oAuth2Response.getName() );
            userDto.setUsename(userName);
            userDto.setRole("ROLE_USER");
            return new CustomOAuth2User(userDto);
        } else {
            existUser.setEmail( oAuth2Response.getEmail());
            existUser.setName(oAuth2Response.getName());
            userRepository.save(existUser);
            UserDto userDto = new UserDto();
            userDto.setName( oAuth2Response.getName() );
            userDto.setUsename(userName);
            userDto.setRole("ROLE_USER");
            return new CustomOAuth2User(userDto);
        }

    }
}
