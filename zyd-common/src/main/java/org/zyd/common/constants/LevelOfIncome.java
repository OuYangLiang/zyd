package org.zyd.common.constants;

/**
 * 
 * 收入水平
 *
 */
public enum LevelOfIncome {
    A0500010("未输入"),
    A0500020("4000以下"),
    A0500030("4000-8000"),
    A0500040("8000-15000"),
    A0500050("15000以上");
	
	private String desc;
	
	public String getDesc() {
		return this.desc;
	}
	
	private LevelOfIncome(String desc) {
		this.desc = desc;
	}
}
