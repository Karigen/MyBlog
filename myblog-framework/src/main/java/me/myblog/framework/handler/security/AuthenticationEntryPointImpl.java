package me.myblog.framework.handler.security;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.myblog.framework.domain.Response;
import me.myblog.framework.enums.HttpCodeEnum;
import me.myblog.framework.utils.WebUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Karigen B
 * @create 2022-11-04 22:18
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        authException.printStackTrace();
        Response<Object> result = null;
        if (authException instanceof BadCredentialsException) {
            result = Response.error(HttpCodeEnum.LOGIN_ERROR.getCode(), authException.getMessage());
        } else if (authException instanceof InsufficientAuthenticationException) {
            result = Response.error(HttpCodeEnum.NEED_LOGIN);
        } else {
            result = Response.error(HttpCodeEnum.SYSTEM_ERROR.getCode(), "认证或授权失败");
        }
        // 响应给前端
        WebUtils.renderString(response, JSON.toJSONString(result));
    }
}
