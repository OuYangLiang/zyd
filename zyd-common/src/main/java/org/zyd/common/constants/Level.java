package org.zyd.common.constants;

/**
 * 
 * 会员等级编号
 *
 */
public enum Level {
    A1600010("V1"),
    A1600020("V2"),
    A1600030("V3");
	
	private String desc;
	
	public String getDesc() {
		return this.desc;
	}
	
	private Level(String desc) {
		this.desc = desc;
	}
}
