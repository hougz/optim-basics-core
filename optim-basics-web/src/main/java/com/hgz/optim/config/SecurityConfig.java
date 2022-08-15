package com.hgz.optim.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/8/7 8:57
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] excludedAuthPages = {
            "/auth/login",
            "/doc.html",
            "/webjars/**",
            "/v2/api-docs",
            //这个和下面两个要加上，否则无法访问后台api
            "/sys/v2/api-docs",
            "/auth/v2/api-docs",
            "/swagger-resources/configuration/ui",
            "/swagger-resources",
            "/swagger-resources/configuration/security",
            "/swagger-ui.html"
    };

    /**
     * 安全拦截机制（最重要）
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                //所有/api/v1/**的请求必须认证通过
                .antMatchers("/api/v1/**").authenticated()
                .antMatchers(excludedAuthPages).permitAll()
                //除了/r/**，其它的请求可以访问
                .anyRequest().permitAll()
        ;
    }
}
