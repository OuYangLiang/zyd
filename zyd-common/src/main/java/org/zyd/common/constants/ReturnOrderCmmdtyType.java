package org.zyd.common.constants;

/**
 * 
 * 退换货物品类型
 *
 */
public enum ReturnOrderCmmdtyType {
    A5700010("商品"),
    A5700020("赠品");
	
    private String desc;

    public String getDesc() {
        return this.desc;
    }

    private ReturnOrderCmmdtyType(String desc) {
        this.desc = desc;
    }
}
