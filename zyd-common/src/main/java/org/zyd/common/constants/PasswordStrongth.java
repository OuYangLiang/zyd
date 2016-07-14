package org.zyd.common.constants;

/**
 * 
 * 密码强度
 *
 */
public enum PasswordStrongth {
    A1200010("未输入"),
    A1200020("低"),
    A1200030("中"),
	A1200040("高");
	
    private String desc;

    public String getDesc() {
        return this.desc;
    }

    private PasswordStrongth(String desc) {
        this.desc = desc;
    }
}
