package org.zyd.common.constants;

/**
 * 
 * 退换货订单状态
 *
 */
public enum ReturnOrderStatus {
    A5100010("审核中"),
    A5100020("待寄件"),
    A5100030("待收件"),
    A5100040("待退款"),
    A5100050("待发货"),
    A5100060("待收货"),
    A5100070("退款审核"),
    A5100080("已退款"),
    A5100090("完成"),
    A5100100("退货失败"),
    A5100110("换货失败");
	
    private String desc;

    public String getDesc() {
        return this.desc;
    }

    private ReturnOrderStatus(String desc) {
        this.desc = desc;
    }
}
