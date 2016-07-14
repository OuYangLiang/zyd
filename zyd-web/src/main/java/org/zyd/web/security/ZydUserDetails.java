package org.zyd.web.security;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.User;

public class ZydUserDetails extends User {
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	
	private BigDecimal partyId;
	
	public BigDecimal getPartyId() {
		return partyId;
	}

	public void setPartyId(BigDecimal partyId) {
		this.partyId = partyId;
	}

	public ZydUserDetails(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, BigDecimal partyId) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		this.partyId = partyId;
	}

	public ZydUserDetails(String username, String password,
			Collection<? extends GrantedAuthority> authorities, BigDecimal partyId) {
		super(username, password, authorities);
		this.partyId = partyId;
	}
}
