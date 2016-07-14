package org.zyd.common.constants;

/**
 * 
 * 国家
 *
 */
public enum Country {
    A0700000("其他"),
    A0700010("中国");
	
	private String desc;
	
	public String getDesc() {
		return this.desc;
	}
	
	private Country(String desc) {
		this.desc = desc;
	}
}
