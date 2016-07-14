package org.zyd.common.constants;

/**
 * 
 * 第三方账号类型
 *
 */
public enum ThirdPartyAcntType {
    A1000010("QQ"),
    A1000020("支付宝"),
    A1000030("微信"),
    A1000040("新浪微博");
	
	private String desc;
	
	public String getDesc() {
		return this.desc;
	}
	
	private ThirdPartyAcntType(String desc) {
		this.desc = desc;
	}
}
