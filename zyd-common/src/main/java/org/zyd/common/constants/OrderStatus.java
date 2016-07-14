package org.zyd.common.constants;

/**
 * 
 * 订单状态
 *
 */
public enum OrderStatus {
    A3400010("待支付"),
    A3400020("待发货"),
    A3400030("待退款"),
    A3400040("待收货"),
    A3400050("完成"),
    A3400060("已取消"),
    A3400070("已退款");

    private String desc;
    
    public String getDesc() {
        return this.desc;
    }
    
    private OrderStatus(String desc) {
        this.desc = desc;
    }
}
