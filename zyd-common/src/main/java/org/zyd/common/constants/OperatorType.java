package org.zyd.common.constants;

/**
 * 
 * 操作方
 *
 */
public enum OperatorType {
    A4400010("未指定"),
    A4400020("我方"),
    A4400030("客户");

    private String desc;
    
    public String getDesc() {
        return this.desc;
    }
    
    private OperatorType(String desc) {
        this.desc = desc;
    }
}
