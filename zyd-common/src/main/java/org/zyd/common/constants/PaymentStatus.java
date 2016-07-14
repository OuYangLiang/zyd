package org.zyd.common.constants;

/**
 * 
 * 支付状态
 *
 */
public enum PaymentStatus {
    A4900010("待支付"),
    A4900020("已支付");
	
    private String desc;

    public String getDesc() {
        return this.desc;
    }

    private PaymentStatus(String desc) {
        this.desc = desc;
    }
}
