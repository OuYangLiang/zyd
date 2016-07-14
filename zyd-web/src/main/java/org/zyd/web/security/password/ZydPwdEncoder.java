package org.zyd.web.security.password;

import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

public class ZydPwdEncoder implements PasswordEncoder {
	private static final Logger log = LoggerFactory.getLogger(ZydPwdEncoder.class);
    private String algorithm;
    
    public String getAlgorithm() {
        return algorithm;
    }

    
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

	@Override
	public String encode(CharSequence rawPassword) {
		try {
			return org.zyd.common.util.PwdEncoder.encodePassword(rawPassword.toString(), algorithm);
		} catch (NoSuchAlgorithmException e) {
			log.error(e.getMessage(), e);
		}
		
		return null;
	}


	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return this.encode(rawPassword).equals(encodedPassword);
	}

}
