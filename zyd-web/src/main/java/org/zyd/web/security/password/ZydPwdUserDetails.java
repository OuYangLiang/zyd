package org.zyd.web.security.password;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.zyd.web.security.ZydUserDetails;

public class ZydPwdUserDetails extends ZydUserDetails {

	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	private Integer salt;

	public Integer getSalt() {
		return salt;
	}

	public void setSalt(Integer salt) {
		this.salt = salt;
	}

	public ZydPwdUserDetails(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, BigDecimal partyId, Integer salt) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities, partyId);
		this.salt = salt;
	}

	public ZydPwdUserDetails(String username, String password,
			Collection<? extends GrantedAuthority> authorities, BigDecimal partyId, Integer salt) {
		super(username, password, authorities, partyId);
		this.salt = salt;
	}

}
