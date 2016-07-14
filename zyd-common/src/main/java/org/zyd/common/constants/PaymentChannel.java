package org.zyd.common.constants;

/**
 * 
 * 支付渠道
 *
 */
public enum PaymentChannel {
    A4800010("第三方代收"),
    A4800020("支付宝"),
    A4800030("微信"),
    A4800040("财付通"),
    A4800050("银行卡"),
    A4800060("信用卡");
	
    private String desc;

    public String getDesc() {
        return this.desc;
    }

    private PaymentChannel(String desc) {
        this.desc = desc;
    }
}
