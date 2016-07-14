package org.zyd.common.constants;

/**
 * 
 * 婚姻状况
 *
 */
public enum MaritalStatus {
    A0300010("未输入"),
    A0300020("未婚"),
    A0300030("已婚");
	
	private String desc;
	
	public String getDesc() {
		return this.desc;
	}
	
	private MaritalStatus(String desc) {
		this.desc = desc;
	}
}
