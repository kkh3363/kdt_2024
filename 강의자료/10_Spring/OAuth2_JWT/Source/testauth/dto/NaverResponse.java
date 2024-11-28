package com.kdt.testauth.dto;

import java.util.Map;

public class NaverResponse implements  OAuth2Response{
    private Map<String, Object> attributes;

    public NaverResponse(Map<String, Object> attributes){
        this.attributes = attributes;
    }
    @Override
    public String getProvider() {
        return "naver";
    }

    @Override
    public String getProviderId() {
        return (String) attributes.get("sub");
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }
}
