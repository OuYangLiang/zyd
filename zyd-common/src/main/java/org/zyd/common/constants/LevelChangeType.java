package org.zyd.common.constants;

/**
 * 
 * 等级变更类型
 *
 */
public enum LevelChangeType {
    A1700010("自动"),
    A1700020("手工");
	
	private String desc;
	
	public String getDesc() {
		return this.desc;
	}
	
	private LevelChangeType(String desc) {
		this.desc = desc;
	}
}
