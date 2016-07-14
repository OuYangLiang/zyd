package org.zyd.common.constants;

/**
 * 
 * 教育程度
 *
 */
public enum Education {
    A0200010("未输入"),
    A0200020("初中"),
    A0200030("高中"),
    A0200040("大专"),
    A0200050("本科"),
    A0200060("硕士"),
    A0200070("博士");
	
	private String desc;
	
	public String getDesc() {
		return this.desc;
	}
	
	private Education(String desc) {
		this.desc = desc;
	}
}
