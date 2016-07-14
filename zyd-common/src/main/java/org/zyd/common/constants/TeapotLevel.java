package org.zyd.common.constants;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * 紫砂壶级别
 *
 */
public enum TeapotLevel {
    A4300010("国家级工艺美术员"),
    A4300020("地方级工艺美术师"),
    A4300030("地方级工艺美术员"),
    A4300040("国家级助理工艺美术员"),
    A4300050("地方级助理工艺美术员");

    private String desc;
    
    public String getDesc() {
        return this.desc;
    }
    
    private TeapotLevel(String desc) {
        this.desc = desc;
    }

    public static Map<String, String> toMaps() {
        Map<String, String> rlt = new LinkedHashMap<String, String>();
        for (TeapotLevel t : TeapotLevel.values()) {
            rlt.put(t.name(), t.getDesc());
        }
        return rlt;
    }
}
