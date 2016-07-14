package org.zyd.store;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zyd.store.entity.TeapotEntity;
import org.zyd.store.mapper.TeapotMapper;

public class TeapotTest extends TestCase {

    private ApplicationContext ctx = null;
    private TeapotMapper mapper = null;

    public TeapotTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(TeapotTest.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        ctx = new ClassPathXmlApplicationContext("application-context.xml");
        mapper = ctx.getBean(TeapotMapper.class);
    }

    public void testInsert() {

        int startId = 1;
        for (int i = 0; i < 5000; i++) {
            List<TeapotEntity> data = new ArrayList<TeapotEntity>();
            long start = System.currentTimeMillis();
            for (int j = 0; j < 1000; j++) {
                TeapotEntity entity = new TeapotEntity();
                entity.setCmmdtyId(new BigDecimal(startId++));
                entity.setCategory(getCategory());
                entity.setCurrentPrice(new BigDecimal(Math.round(Math.random() * 1000)));
                entity.setCmmdtyName("紫砂壶");
                entity.setCmmdtyNum("1" + "" + StringUtils.leftPad(entity.getCmmdtyId().toString(), 7, "0"));
                entity.setCmmdtyDesc("宜兴紫砂壶");
                entity.setPriceRegion(getPriceRegion());
                entity.setNumStored((int) Math.round(Math.random() * 1000) + 1);
                entity.setNumSales((int) Math.round(Math.random() * 1000) + 1);
                entity.setNumEvaluated((int) Math.round(Math.random() * 10000) + 1);
                entity.setProposedPrice(new BigDecimal(Math.round(Math.random() * 1000)));
                entity.setDefaultImageAddrs("/opt/ss.x");
                entity.setType(getType());
                entity.setShape(getShape());
                entity.setMaterial(getMaterial());
                entity.setSize((int) Math.round(Math.random() * 6) * 100);
                entity.setLevel(getLevel());
                entity.setProducer("欧老");
                entity.setSalesMode(getSalesMode());
                entity.setShelvesTime(new Date());
                entity.setUpdateTime(new Timestamp(new Date().getTime()));
                data.add(entity);
            }
            mapper.insertBatch(data);
            long end = System.currentTimeMillis();
            System.out.println(i + "次插入时间为:" + (end - start) + "毫秒");
        }
    }

    //
    // public void testQuery() {
    // TeapotTerm term = new TeapotTerm();
    // term.setCategory("10000020");
    //
    // List<TeapotEntity> list = mapper.getList(term);
    //
    // assertNotNull(list);
    // assertEquals(1, list.size());
    //
    // TeapotEntity entity = list.get(0);
    // cmmdtyId = entity.getCmmdtyId();
    // // assertEquals("102002", entity.getAuditor());
    // // assertEquals("status", entity.getCmmdtyStatus());
    //
    // }
    //
    // public void testUpdate() {
    // TeapotEntity entity = new TeapotEntity();
    // entity.setCmmdtyId(cmmdtyId);
    // // entity.setCmmdtyStatus("status1");
    //
    // int i = mapper.updateBySelective(entity);
    //
    // assertEquals(1, i);
    //
    // TeapotTerm term = new TeapotTerm();
    // term.setCategory("10000020");
    //
    // List<TeapotEntity> list = mapper.getList(term);
    //
    // assertNotNull(list);
    // assertEquals(1, list.size());
    //
    // entity = list.get(0);
    // // assertEquals("status1", entity.getCmmdtyStatus());
    // }
    //
    // public void testDelete() {
    // TeapotEntity entity = new TeapotEntity();
    // entity.setCmmdtyId(cmmdtyId);
    //
    // mapper.delete(entity);
    //
    // TeapotTerm term = new TeapotTerm();
    // term.setCmmdtyId(cmmdtyId);
    //
    // List<TeapotEntity> list = mapper.getList(term);
    //
    // assertTrue(null == list || list.isEmpty());
    // }

    private String getCategory() {
        String[] cate = new String[] { "A2100010", "A2100020", "A2100030", "A2100040", "A2100050", "A2100060",
                "A2100070", "A2100080", "A2100090", "A2100100", "A2100110", "A2100120", "A2100130", "A2100140",
                "A2100150", "A2100160", "A2100170", "A2100180", "A2100190", "A2100200", "A2100210", "A2100220",
                "A2100230" };

        return cate[(int) Math.round(Math.random() * 22)];
    }

    private String getPriceRegion() {
        String[] region = new String[] { "A2200010", "A2200020", "A2200030", "A2200040", "A2200050" };

        return region[(int) Math.round(Math.random() * 4)];
    }

    private String getType() {
        String[] type = new String[] { "A2350010", "A2350020", "A2350030", "A2350040" };

        return type[(int) Math.round(Math.random() * 3)];
    }

    private String getShape() {
        String[] shape = new String[] { "A2400010", "A2400011", "A2400012", "A2400013", "A2400014", "A2400015",
                "A2400016", "A2400017", "A2400018", "A2400019", "A2400020", "A2400021", "A2400022", "A2400023",
                "A2400024", "A2400025", "A2400026", "A2400027", "A2400028", "A2400029", "A2400030", "A2400031",
                "A2400032", "A2400033", "A2400034", "A2400035", "A2400036", "A2400037", "A2400038", "A2400039",
                "A2400040", "A2400041", "A2400042", "A2400043", "A2400044", "A2400045", "A2400046", "A2400047",
                "A2400048", "A2400049", "A2400050", "A2400051", "A2400052", "A2400053", "A2400054", "A2400055",
                "A2400056", "A2400057", "A2400058", "A2400059", "A2400060", "A2400061", "A2400062", "A2400063",
                "A2400064", "A2400065", "A2400066", "A2400067", "A2400068", "A2400069", "A2400070", "A2410010",
                "A2410011", "A2410012", "A2410013", "A2410014", "A2410015", "A2410016", "A2410017", "A2410018",
                "A2410019", "A2410020", "A2410021", "A2410022", "A2410023", "A2410024", "A2410025", "A2420010",
                "A2420011", "A2420012", "A2420013", "A2420014", "A2420015", "A2420016", "A2430010", "A2430011",
                "A2430012", "A2430013", "A2430014", "A2430015", "A2430016", "A2430017", "A2430018", "A2430019",
                "A2430020", "A2430021", "A2430022", "A2430023", "A2430024", "A2430025", "A2430026", "A2430027" };

        return shape[(int) Math.round(Math.random() * 101)];
    }

    private String getMaterial() {
        String[] material = new String[] { "A2500010", "A2500011", "A2500012", "A2500013", "A2500014", "A2500015",
                "A2500016", "A2500017", "A2500018", "A2500019", "A2500020", "A2500021", "A2500022", "A2500023",
                "A2500024", "A2500025", "A2500026", "A2500027", "A2500028", "A2500029", "A2500030", "A2500031",
                "A2500032", "A2500033" };

        return material[(int) Math.round(Math.random() * 23)];
    }

    private String getLevel() {
        String[] level = new String[] { "A4300010", "A4300020", "A4300030", "A4300040", "A4300050" };

        return level[(int) Math.round(Math.random() * 4)];
    }

    private String getSalesMode() {
        String[] salesMode = new String[] { "A2600010", "A2600020" };

        return salesMode[(int) Math.round(Math.random() * 1)];
    }
}
