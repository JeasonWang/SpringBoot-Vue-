package com.wanghuan.blogserver.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:tokenConfig.properties"})
public class TokenConfig {
    @Value("${token.expiration}")
    private Long expiration;
    @Value("${token.iss}")
    private String iss;
    @Value("${token.secret}")
    private String secret;

    public long getExpiration() {
        return expiration;
    }

    public String getIss() {
        return iss;
    }

    public String getSecret() {
        return secret;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
