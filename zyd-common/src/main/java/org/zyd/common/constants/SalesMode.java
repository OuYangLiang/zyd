package org.zyd.common.constants;

/**
 * 
 * 销售模式
 *
 */
public enum SalesMode {
    A2600010("普通"),
    A2600020("询价");

    private String desc;
    
    public String getDesc() {
        return this.desc;
    }
    
    private SalesMode(String desc) {
        this.desc = desc;
    }
}
