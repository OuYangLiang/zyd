package org.zyd.common.constants;

/**
 * 
 * 物流公司代码
 *
 */
public enum LogisticsCompCode {
	A3700010("顺丰快递"),
	A3700020("EMS"),
	A3700030("宅急送");
	
	private String desc;

    public String getDesc() {
        return this.desc;
    }

    private LogisticsCompCode(String desc) {
        this.desc = desc;
    }
}