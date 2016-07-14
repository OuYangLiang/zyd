package org.zyd.common.constants;

/**
 * 
 * 分类
 *
 */
public enum Category {
	A2100010("商品壶"),
	/*A2100020("品牌"),
	A2100030("名家"),
	A2100040("礼品"),*/
	A2100050("茶叶"),
	A2100060("公道杯"),
	A2100070("瓷杯"),
	A2100080("紫砂杯"),
	A2100090("茶叶罐"),
	A2100100("壶承"),
	A2100110("茶匙"),
	A2100120("茶夹"),
	A2100130("茶则"),
	A2100140("茶针"),
	A2100150("茶漏"),
	A2100160("茶桶"),
	A2100170("茶盘"),
	A2100180("茶席"),
	A2100190("养壶巾"),
	A2100200("养壶笔"),
	A2100210("茶垫"),
	A2100220("茶宠"),
	A2100230("其他");
	
	private String desc;

    public String getDesc() {
        return this.desc;
    }

    private Category(String desc) {
        this.desc = desc;
    }
}
