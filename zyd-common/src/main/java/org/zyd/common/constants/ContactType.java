package org.zyd.common.constants;

/**
 * 
 * 联系类型
 *
 */
public enum ContactType {
	A0600010("送货地址"),
	A0600020("家庭地址"),
	A0600030("单位地址");
	
	private String desc;

    public String getDesc() {
        return this.desc;
    }

    private ContactType(String desc) {
        this.desc = desc;
    }
}

