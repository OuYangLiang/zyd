package org.zyd.common.constants;

/**
 * 
 * 支付方式
 *
 */
public enum PaymentMethod {
    A4700010("货到付款"), 
    A4700020("在线支付");

    private String desc;

    public String getDesc() {
        return this.desc;
    }

    private PaymentMethod(String desc) {
        this.desc = desc;
    }
}
