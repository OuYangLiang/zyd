package org.zyd.common.constants;

/**
 * 
 * 商品图片类型
 *
 */
public enum CommodityImageType {
	A5800010("商品图（小）"),
	A5800020("商品图（中）"),
	A5800030("商品图（大）"),
	A5800040("详情图");

	private String desc;

    public String getDesc() {
        return this.desc;
    }

    private CommodityImageType(String desc) {
        this.desc = desc;
    }
}
