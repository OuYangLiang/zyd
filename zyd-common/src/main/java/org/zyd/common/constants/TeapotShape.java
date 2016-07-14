package org.zyd.common.constants;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * 壶型
 *
 */
public enum TeapotShape {
	A2400010("石瓢"),
	A2400011("如意"),
	A2400012("仿古"),
	A2400013("西施"),
	A2400014("井栏"),
	A2400015("莲子"),
	A2400016("掇球"),
	A2400017("掇只"),
	A2400018("秦权"),
	A2400019("合欢"),
	A2400020("大彬提梁"),
	A2400021("汉铎"),
	A2400022("匏瓜"),
	A2400023("上新桥"),
	A2400024("华颖"),
	A2400025("柱础"),
	A2400026("曲壶"),
	A2400027("石瓢提梁"),
	A2400028("合盘"),
	A2400029("横云"),
	A2400030("半瓦"),
	A2400031("茄段"),
	A2400032("葫芦"),
	A2400033("德钟"),
	A2400034("虚扁"),
	A2400035("潘壶"),
	A2400036("圆珠"),
	A2400037("笑樱"),
	A2400038("线圆"),
	A2400039("一粒珠"),
	A2400040("美人肩"),
	A2400041("洋桶"),
	A2400042("龙旦"),
	A2400043("扁腹"),
	A2400044("天际"),
	A2400045("玉笠"),
	A2400046("提璧"),
	A2400047("瓦当"),
	A2400048("汲直"),
	A2400049("龙带"),
	A2400050("镜瓦"),
	A2400051("容天"),
	A2400052("半月"),
	A2400053("乳鼎"),
	A2400054("匏尊"),
	A2400055("牛盖莲子"),
	A2400056("水平"),
	A2400057("梨形"),
	A2400058("文旦"),
	A2400059("汉扁"),
	A2400060("周盘"),
	A2400061("大彬如意"),
	A2400062("汉瓦"),
	A2400063("思亭"),
	A2400064("汉君"),
	A2400065("雨露天星"),
	A2400066("曼生提梁"),
	A2400067("狮球"),
	A2400068("鹧鸪提梁"),
	A2400069("吴经提梁"),
	A2400070("石扁"),
	A2410010("四方"),
	A2410011("传炉"),
	A2410012("雪华"),
	A2410013("砖方"),
	A2410014("合斗"),
	A2410015("菱形四方"),
	A2410016("六方"),
	A2410017("宫灯"),
	A2410018("亚明四方"),
	A2410019("僧帽壶"),
	A2410020("方斗"),
	A2410021("八方"),
	A2410022("汉方"),
	A2410023("升方"),
	A2410024("青玉四方"),
	A2410025("四方桥鼎"),
	A2420010("菱花"),
	A2420011("筋纹"),
	A2420012("龙头一捆竹"),
	A2420013("仿古如意"),
	A2420014("合菱"),
	A2420015("菊蕾"),
	A2420016("葵仿古"),
	A2430010("供春"),
	A2430011("鱼化龙"),
	A2430012("报春"),
	A2430013("松鼠葡萄"),
	A2430014("西瓜"),
	A2430015("束柴三友"),
	A2430016("竹段"),
	A2430017("寿桃"),
	A2430018("双线竹鼓"),
	A2430019("佛手"),
	A2430020("环龙三足"),
	A2430021("裙花提梁"),
	A2430022("南瓜"),
	A2430023("牡丹"),
	A2430024("松竹梅"),
	A2430025("风卷葵"),
	A2430026("荸荠"),
	A2430027("南瓜提梁");

	private String desc;

    public String getDesc() {
        return this.desc;
    }

    private TeapotShape(String desc) {
        this.desc = desc;
    }

    public static Map<String, String> toMaps() {
        Map<String, String> rlt = new LinkedHashMap<String, String>();
        for (TeapotShape t : TeapotShape.values()) {
            rlt.put(t.name(), t.getDesc());
        }
        return rlt;
    }
    
    public static Map<String, String> to240Maps() {
        Map<String, String> rlt = new LinkedHashMap<String, String>();
        for (TeapotShape t : TeapotShape.values()) {
            if (t.name().startsWith("A240")) {
                rlt.put(t.name(), t.getDesc());
            }
        }
        return rlt;
    }
    
    public static Map<String, String> to241Maps() {
        Map<String, String> rlt = new LinkedHashMap<String, String>();
        for (TeapotShape t : TeapotShape.values()) {
            if (t.name().startsWith("A241")) {
                rlt.put(t.name(), t.getDesc());
            }
        }
        return rlt;
    }
    
    public static Map<String, String> to242Maps() {
        Map<String, String> rlt = new LinkedHashMap<String, String>();
        for (TeapotShape t : TeapotShape.values()) {
            if (t.name().startsWith("A242")) {
                rlt.put(t.name(), t.getDesc());
            }
        }
        return rlt;
    }
    
    public static Map<String, String> to243Maps() {
        Map<String, String> rlt = new LinkedHashMap<String, String>();
        for (TeapotShape t : TeapotShape.values()) {
            if (t.name().startsWith("A243")) {
                rlt.put(t.name(), t.getDesc());
            }
        }
        return rlt;
    }
}
