package org.zyd.web.security.verifycode;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class ZydVerifyCodeDaoAuthenticationProvider extends DaoAuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
		if (authentication.getDetails() != null && "dynamicPwd".equals(authentication.getDetails())) {
			return super.authenticate(authentication);
		}
		
		return null;
	}

}
