package org.zyd.common.constants;

/**
 * 
 * 退款方式
 *
 */
public enum RefundMethod {
    A5400010("委托第三方退款"),
    A5400020("在线退款");

    private String desc;
    
    public String getDesc() {
        return this.desc;
    }
    
    private RefundMethod(String desc) {
        this.desc = desc;
    }
}
