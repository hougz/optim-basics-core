package com.hgz.optim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author hgz
 * @version 1.0
 * @date 2021/11/24 20:25
 */
@Configuration
public class TokenConfig {

    private String SIGNING_KEY = "uaa123";


   /* @Bean  基于内存
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }*/

    @Bean
    public TokenStore tokenStore() {
        //基于jwt
        return new JwtTokenStore(accessTokenConverter());
    }



    /**
     * jwt配置
     *
     * @return
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY);
        return converter;
    }


}
