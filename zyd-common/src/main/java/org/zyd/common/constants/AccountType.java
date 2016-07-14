package org.zyd.common.constants;

/**
 * 
 * 账号类型
 * 
 */
public enum AccountType {
	A0800010("手机"),
	A0800020("邮箱"),
	A0800030("用户名");
	
    private String desc;

    public String getDesc() {
        return this.desc;
    }

    private AccountType(String desc) {
        this.desc = desc;
    }
}
