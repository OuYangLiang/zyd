package org.zyd.common.constants;

/**
 * 
 * 账号可用状态
 *
 */
public enum AccountStatus {
    A0900010("可用"),
    A0900020("锁定");
	
	private String desc;
	
	public String getDesc() {
		return this.desc;
	}
	
	private AccountStatus(String desc) {
		this.desc = desc;
	}
}
