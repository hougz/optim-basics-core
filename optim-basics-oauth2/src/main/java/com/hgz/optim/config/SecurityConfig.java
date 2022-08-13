package com.hgz.optim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
     * 认证管理器
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 密码加密
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 自定义登录页面策略
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭防火
       /* http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/**").hasAnyAuthority("p1")
                //放行授权服务器的几个端点请求、登录请求、登出请求。
                .antMatchers("/login/**", "/error.html")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/login.html")
                //登录成功后
                .successForwardUrl("/toMain")
                .failureForwardUrl("/toError");*/
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1").hasAnyAuthority("p1")
                .antMatchers(excludedAuthPages).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
        ;
    }
}
