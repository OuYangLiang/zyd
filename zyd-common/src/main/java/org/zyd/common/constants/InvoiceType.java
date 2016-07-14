package org.zyd.common.constants;

/**
 * 
 * 发票类型
 *
 */
public enum InvoiceType {
    A3500010("普通发票"),
    A3500020("增值发票"),
    A3500030("电子发票");

    private String desc;
    
    public String getDesc() {
        return this.desc;
    }
    
    private InvoiceType(String desc) {
        this.desc = desc;
    }
}
