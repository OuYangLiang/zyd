package org.zyd.common.constants;

/**
 * 
 * 订单商品状态
 *
 */
public enum OrderCommodityStatus {
    A4500010("正常"),
    A4500020("退货中"),
    A4500030("换货中"),
    A4500040("已退货");

    private String desc;
    
    public String getDesc() {
        return this.desc;
    }
    
    private OrderCommodityStatus(String desc) {
        this.desc = desc;
    }
}
