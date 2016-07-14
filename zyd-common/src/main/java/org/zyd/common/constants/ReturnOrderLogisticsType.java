package org.zyd.common.constants;

/**
 * 
 * 退换货物流类型
 *
 */
public enum ReturnOrderLogisticsType {
    A5300010("我方寄送"),
    A5300020("客户寄送");
	
    private String desc;

    public String getDesc() {
        return this.desc;
    }

    private ReturnOrderLogisticsType(String desc) {
        this.desc = desc;
    }
}
