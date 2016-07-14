package org.zyd.common.constants;

/**
 * 
 * 订单商品评价状态
 *
 */
public enum EvaluationStatus {
    A4600010("待评价"),
    A4600020("已评价");

    private String desc;
    
    public String getDesc() {
        return this.desc;
    }
    
    private EvaluationStatus(String desc) {
        this.desc = desc;
    }
}
