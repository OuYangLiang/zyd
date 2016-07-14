package org.zyd.common.constants;

/**
 * 
 * 退换货类型
 *
 */
public enum ReturnOrderType {
    A5000010("退货"),
    A5000020("换货"),
    A5000030("保养");
	
    private String desc;

    public String getDesc() {
        return this.desc;
    }

    private ReturnOrderType(String desc) {
        this.desc = desc;
    }
}
