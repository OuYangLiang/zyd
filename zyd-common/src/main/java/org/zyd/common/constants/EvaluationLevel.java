package org.zyd.common.constants;

/**
 * 
 * 评价级别
 *
 */
public enum EvaluationLevel {
    A3100010("好评"),
    A3100020("中评"),
    A3100030("差评");

    private String desc;
    
    public String getDesc() {
        return this.desc;
    }
    
    private EvaluationLevel(String desc) {
        this.desc = desc;
    }
}
