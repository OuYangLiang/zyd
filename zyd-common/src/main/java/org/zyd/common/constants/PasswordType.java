package org.zyd.common.constants;

/**
 * 
 * 密码类型
 *
 */
public enum PasswordType {
	A1100010("登录密码"),
	A1100020("支付密码");
	
    private String desc;

    public String getDesc() {
        return this.desc;
    }

    private PasswordType(String desc) {
        this.desc = desc;
    }
}
