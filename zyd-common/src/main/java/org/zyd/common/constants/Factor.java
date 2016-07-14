package org.zyd.common.constants;

/**
 * 
 * 等级因素
 *
 */
public enum Factor {
    A1800010("累计积分"),
    A1800020("购物天数");
	
	private String desc;
	
	public String getDesc() {
		return this.desc;
	}
	
	private Factor(String desc) {
		this.desc = desc;
	}
}
