package org.zyd.web.security.password;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.zyd.web.security.password.ZydPwdUserDetails;

public class ZydPwdDaoAuthenticationProvider extends DaoAuthenticationProvider {
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
		if (authentication.getDetails() == null ) {
			return super.authenticate(authentication);
		}
		
		return null;
	}

	@Override
	@SuppressWarnings("deprecation")
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		Integer salt = null;
		
		if (userDetails instanceof ZydPwdUserDetails) {
			salt = ((ZydPwdUserDetails) userDetails).getSalt();
		}

		if (authentication.getCredentials() == null) {
			logger.debug("Authentication failed: no credentials provided");

			throw new BadCredentialsException(messages.getMessage(
					"AbstractUserDetailsAuthenticationProvider.badCredentials",
					"Bad credentials"));
		}

		String presentedPassword = salt.toString() + authentication.getCredentials().toString();

		if (!this.getPasswordEncoder().isPasswordValid(userDetails.getPassword(),
				presentedPassword, null)) {
			logger.debug("Authentication failed: password does not match stored value");

			throw new BadCredentialsException(messages.getMessage(
					"AbstractUserDetailsAuthenticationProvider.badCredentials",
					"Bad credentials"));
		}
	}

}
