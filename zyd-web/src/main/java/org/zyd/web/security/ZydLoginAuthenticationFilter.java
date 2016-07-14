package org.zyd.web.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class ZydLoginAuthenticationFilter extends
		UsernamePasswordAuthenticationFilter {
	
	private boolean postOnly = true;
	
	@Override
	public void setPostOnly(boolean postOnly) {
		this.postOnly = postOnly;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		
		if (postOnly && !request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException(
					"Authentication method not supported: " + request.getMethod());
		}
		
		if (this.isDynamicPwd(request)) {
			request.getSession().setAttribute("dynamicPwd", "dynamicPwd");
		} else {
			request.getSession().removeAttribute("dynamicPwd");
		}

		String username = obtainUsername(request);
		if (username == null || username.trim().isEmpty()) {
			throw new BadCredentialsException("请输入手机号码");
		}
		
		String password = obtainPassword(request);
		if (password == null || password.trim().isEmpty()) {
			if (this.isDynamicPwd(request) ) {
				throw new BadCredentialsException("请输入手机验证码");
			} else {
				throw new BadCredentialsException("请输入登录密码");
			}
		}
		
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
				username, password);

		setDetails(request, authRequest);

		return this.getAuthenticationManager().authenticate(authRequest);
	}

	@Override
	protected void setDetails(HttpServletRequest request,
			UsernamePasswordAuthenticationToken authRequest) {
		if (this.isDynamicPwd(request)) {
			authRequest.setDetails("dynamicPwd");
		}
	}
	
	private boolean isDynamicPwd(HttpServletRequest request) {
		String dynamicPwd = request.getParameter("dynamicPwd");
		
		return null != dynamicPwd && "Y".equalsIgnoreCase(dynamicPwd.trim());
	}
	
}
