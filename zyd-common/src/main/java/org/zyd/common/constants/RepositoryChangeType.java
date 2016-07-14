package org.zyd.common.constants;

/**
 * 
 * 库存变化原因
 *
 */
public enum RepositoryChangeType {
    A3200010("采购"),
    A3200020("销售"),
    A3200030("人工盘点");
    
    private String desc;
    
    public String getDesc() {
        return this.desc;
    }
    
    private RepositoryChangeType(String desc) {
        this.desc = desc;
    }
}
