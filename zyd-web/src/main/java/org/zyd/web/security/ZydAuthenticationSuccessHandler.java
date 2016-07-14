package org.zyd.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.zyd.web.constants.CommonConstants;

import com.google.gson.Gson;

public class ZydAuthenticationSuccessHandler
		implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		request.getSession().removeAttribute("dynamicPwd");
		request.getSession().setAttribute(CommonConstants.USER_SESSION_KEY, authentication.getPrincipal());
		
		String url = request.getRequestURI();
		
		if (url.indexOf("async") == -1) {
			SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);
			RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
			
			String curl = request.getParameter("curl");
			if (null != curl && !curl.isEmpty()) {
				redirectStrategy.sendRedirect(request, response, curl);
				return;
			}
			
			if(savedRequest != null) {
	            redirectStrategy.sendRedirect(request, response, savedRequest.getRedirectUrl());
	            return;
	        }else{
	        	redirectStrategy.sendRedirect(request, response, "/");
	        	return;
	        }
		} else {
			response.setHeader("Content-Type", "application/json;charset=UTF-8");
	        response.getWriter().write(new Gson().toJson(new AsyncLoginRlt("0", null)));
	        response.getWriter().flush();
		}

	}

}
