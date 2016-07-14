package org.zyd.common.constants;

/**
 * 
 * 茶叶等级
 *
 */
public enum TeaLevel {
    A2900010("特级"),
    A2900020("一级"),
    A2900030("二级"),
    A2900040("三级");

    private String desc;
    
    public String getDesc() {
        return this.desc;
    }
    
    private TeaLevel(String desc) {
        this.desc = desc;
    }
}
