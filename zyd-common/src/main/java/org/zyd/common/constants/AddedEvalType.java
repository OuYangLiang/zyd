package org.zyd.common.constants;

/**
 * 
 * 追评类型
 * 
 */
public enum AddedEvalType {
	A3150010("客户追评"), 
	A3150020("官方回复");
	
    private String desc;

    public String getDesc() {
        return this.desc;
    }

    private AddedEvalType(String desc) {
        this.desc = desc;
    }
}
