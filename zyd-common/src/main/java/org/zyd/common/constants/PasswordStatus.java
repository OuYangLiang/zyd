package org.zyd.common.constants;

/**
 * 
 * 密码可用状态
 *
 */
public enum PasswordStatus {
    A1300010("可用"),
    A1300020("锁定"),
    A1300030("过期");
	
    private String desc;

    public String getDesc() {
        return this.desc;
    }

    private PasswordStatus(String desc) {
        this.desc = desc;
    }
}
