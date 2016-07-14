package org.zyd.store;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zyd.store.entity.PurchaseOrderEntity;
import org.zyd.store.mapper.PurchaseOrderMapper;
import org.zyd.store.term.PurchaseOrderTerm;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PurchaseOrderTest extends TestCase {
	private ApplicationContext ctx = null;

    public PurchaseOrderTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(PurchaseOrderTest.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        ctx = new ClassPathXmlApplicationContext("application-context.xml");
    }
    
    
    public void testApp() {
    	PurchaseOrderMapper mapper = ctx.getBean(PurchaseOrderMapper.class);
    	PurchaseOrderTerm term = new PurchaseOrderTerm();
    	
    	
    	List<PurchaseOrderEntity> list = mapper.select(term);
    	assertTrue(list == null || list.isEmpty());
    	
    	
    	PurchaseOrderEntity entity = new PurchaseOrderEntity();
    	entity.setOrderNum("testNum");
    	entity.setSubmitTime(new Timestamp(new Date().getTime()));
    	entity.setOrderStatus("12341234");
    	entity.setOrderTotalPrice(BigDecimal.ONE);
    	entity.setPointConsumed(BigDecimal.valueOf(20));
    	entity.setLogisticsAmt(BigDecimal.valueOf(100));
    	entity.setFreeLogisticsAmt(false);
    	entity.setOrderShouldPayment(BigDecimal.valueOf(120));
    	entity.setOrderActualPayment(BigDecimal.valueOf(150));
    	entity.setPartyId(BigDecimal.valueOf(0));
    	
    	mapper.insert(entity);
    	assertNotNull(entity.getOrderId());
    	
    	term.setOrderNum("testNum");
    	list = mapper.select(term);
    	assertEquals(1, list.size());
    	assertEquals("12341234", list.get(0).getOrderStatus());
    	
    	
    	BigDecimal orderId = entity.getOrderId();
    	entity = new PurchaseOrderEntity();
    	entity.setOrderId(orderId);
    	entity.setOrderStatus("43214321");
    	
    	mapper.updateBySelective(entity);
    	
    	list = mapper.select(term);
    	assertEquals(1, list.size());
    	assertEquals("43214321", list.get(0).getOrderStatus());
    	
    	mapper.delete(list.get(0));
    	
    	list = mapper.select(term);
    	assertTrue(list == null || list.isEmpty());
    }
}
