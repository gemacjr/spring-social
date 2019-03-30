package com.swiftbeard.springsocial.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;


@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private final Auth auth = new Auth();
    private final OAuth2 oauth2 = new OAuth2();

    public static class Auth{
        private String tokenSecret;
        private long tokenExpirationMsec;

        public String getTokenSecret() {
            return tokenSecret;
        }

        public void setTokenSecret(String tokenSecret) {
            this.tokenSecret = tokenSecret;
        }

        public long getTokenExpirationMsec() {
            return tokenExpirationMsec;
        }

        public void setTokenExpirationMsec(long tokenExpirationMsec) {
            this.tokenExpirationMsec = tokenExpirationMsec;
        }
    }

    public static final class OAuth2 {
        private List<String> authorizeRedirectUris = new ArrayList<>();

        public List<String> getAuthorizeRedirectUris(){
            return authorizeRedirectUris;
        }

        public OAuth2 authorizedRedirectUris(List<String> authorizeRedirectUris){
            this.authorizeRedirectUris = authorizeRedirectUris;
            return this;
        }
    }

    public Auth getAuth(){
        return auth;
    }

    public OAuth2 getOauth2(){
        return oauth2;
    }
}
