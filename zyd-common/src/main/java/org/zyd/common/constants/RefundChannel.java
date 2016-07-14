package org.zyd.common.constants;

/**
 * 
 * 退款渠道
 *
 */
public enum RefundChannel {
    A5600010("委托第三方退款"),
    A5600020("支付宝"),
    A5600030("微信"),
    A5600040("财付通"),
    A5600050("银行卡"),
    A5600060("信用卡");

    private String desc;
    
    public String getDesc() {
        return this.desc;
    }
    
    private RefundChannel(String desc) {
        this.desc = desc;
    }
}
