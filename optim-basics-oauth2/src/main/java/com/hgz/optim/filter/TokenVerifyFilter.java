package com.hgz.optim.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/8/16 20:53
 */
@Slf4j
public class TokenVerifyFilter extends BasicAuthenticationFilter {

    public TokenVerifyFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }


    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        log.info("请求token 值：{}", header);
        if (header == null || !header.startsWith("Bearer ")) {
            //如果携带错误的token，则给用户提示请登录！
            chain.doFilter(request, response);
        } else {
            //如果携带了正确格式的token要先得到token
            String token = header.replace("Bearer ", "");
            //通过公钥进行解密：验证tken是否正确
            if (token != null) {
                UsernamePasswordAuthenticationToken authResult = new UsernamePasswordAuthenticationToken("hgz", null, null);
                //将认证信息存到安全上下文中
                SecurityContextHolder.getContext().setAuthentication(authResult);
                chain.doFilter(request, response);
            }
        }
    }

}
