package org.zyd.common.constants;

/**
 * 
 * 退款状态
 *
 */
public enum RefundStatus {
    A5500010("待退款"),
    A5500020("已退款");

    private String desc;
    
    public String getDesc() {
        return this.desc;
    }
    
    private RefundStatus(String desc) {
        this.desc = desc;
    }
}
