package org.zyd.common.constants;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * 紫砂壶价格区间
 *
 */
public enum TeapotPriceRegion {
    A2200010("1000以下"),
    A2200020("1000-3000"),
    A2200030("3000-5000"),
    A2200040("5000-10000"),
    A2200050("10000以上");

    private String desc;
    
    public String getDesc() {
        return this.desc;
    }
    
    private TeapotPriceRegion(String desc) {
        this.desc = desc;
    }

    public static Map<String, String> toMaps() {
        Map<String, String> rlt = new LinkedHashMap<String, String>();
        for (TeapotPriceRegion t : TeapotPriceRegion.values()) {
            rlt.put(t.name(), t.getDesc());
        }
        return rlt;
    }
}
