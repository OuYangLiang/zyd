package org.zyd.common.constants;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * 器型
 * 
 */
public enum TeapotType {
    A2350010("圆器"),
    A2350020("方器"),
    A2350030("筋纹器"),
    A2350040("花塑器");

    private String desc;

    public String getDesc() {
        return this.desc;
    }

    private TeapotType(String desc) {
        this.desc = desc;
    }

    public static Map<String, String> toMaps() {
        Map<String, String> rlt = new LinkedHashMap<String, String>();
        for (TeapotType t : TeapotType.values()) {
            rlt.put(t.name(), t.getDesc());
        }
        return rlt;
    }
}
