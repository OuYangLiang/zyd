package org.zyd.common.constants;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * 泥料
 *
 */
public enum TeapotMaterial {
    A2500010("天青泥"),
    A2500011("岩中泥"),
    A2500012("降坡泥"),
    A2500013("底槽青"),
    A2500014("红棕泥"),
    A2500015("大红泥"),
    A2500016("本山绿泥"),
    A2500017("黑铁砂"),
    A2500018("大红袍"),
    A2500019("兰山朱泥"),
    A2500020("紫茄泥"),
    A2500021("墨绿泥"),
    A2500022("拼紫泥"),
    A2500023("清水泥"),
    A2500024("紫皂青"),
    A2500025("黄龙山石黄"),
    A2500026("甲子年紫砂"),
    A2500027("铁星泥"),
    A2500028("细黑星紫砂"),
    A2500029("朱泥"),
    A2500030("段泥"),
    A2500031("白泥"),
    A2500032("夹泥"),
    A2500033("黄泥");
    
    private String desc;
    
    public String getDesc() {
        return this.desc;
    }
    
    private TeapotMaterial(String desc) {
        this.desc = desc;
    }

    public static Map<String, String> toMaps() {
        Map<String, String> rlt = new LinkedHashMap<String, String>();
        for (TeapotMaterial t : TeapotMaterial.values()) {
            rlt.put(t.name(), t.getDesc());
        }
        return rlt;
    }
}
