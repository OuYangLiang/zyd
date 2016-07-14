package org.zyd.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.google.gson.Gson;

public class ZydAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		
		String url = request.getRequestURI();
		
		if (url.indexOf("async") == -1) {
			super.onAuthenticationFailure(request, response, exception);
		} else {
			response.setHeader("Content-Type", "application/json;charset=UTF-8");
	        response.getWriter().write(new Gson().toJson(new AsyncLoginRlt("1", exception.getMessage())));
	        response.getWriter().flush();
		}
		
	}

}
