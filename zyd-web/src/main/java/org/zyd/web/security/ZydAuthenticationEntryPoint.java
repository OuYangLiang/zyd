package org.zyd.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import com.google.gson.Gson;

public class ZydAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint{

	public ZydAuthenticationEntryPoint(String loginFormUrl) {
		super(loginFormUrl);
	}

	@Override
	public void commence(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {
		
		String url = request.getRequestURI();
		 
        // 非ajax请求
        if (url.indexOf("async") == -1) {
        	super.commence(request, response, authException);
        	return;
        }
		
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        response.getWriter().write(new Gson().toJson(new AsyncLoginRlt("2", null)));
        response.getWriter().flush();
	}

}
