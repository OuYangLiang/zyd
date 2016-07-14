package org.zyd.common.constants;

/**
 * 
 * 场景
 *
 */
public enum Scenario {
	A1900010("签到"),
	A1900020("购物返"),
	A1900030("购物抵现"),
	A1900040("评价返"),
	A1900050("洒单返"),
	A1900060("退货加回"),
	A1900070("退货扣减");
	
	private String desc;

    public String getDesc() {
        return this.desc;
    }

    private Scenario(String desc) {
        this.desc = desc;
    }
}
