package org.zyd.common.constants;

/**
 * 
 * 性别
 *
 */
public enum Gender {
    A0400010("未输入"),
    A0400020("男"),
    A0400030("女");
	
	private String desc;
	
	public String getDesc() {
		return this.desc;
	}
	
	private Gender(String desc) {
		this.desc = desc;
	}
}
