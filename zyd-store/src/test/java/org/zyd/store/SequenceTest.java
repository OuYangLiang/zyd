package org.zyd.store;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zyd.store.entity.SequenceEntity;
import org.zyd.store.mapper.SequenceMapper;

public class SequenceTest extends TestCase {

    private ApplicationContext ctx = null;
    private SequenceMapper mapper = null;

    public SequenceTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(SequenceTest.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        ctx = new ClassPathXmlApplicationContext("application-context.xml");
        mapper = ctx.getBean(SequenceMapper.class);
    }

    public void testInsert() {
        SequenceEntity param = new SequenceEntity();
        mapper.insertBoutiqueSequence(param);
        System.out.println(param.getSeq());
        param = new SequenceEntity();
        mapper.insertTeapotSequence(param);
        System.out.println(param.getSeq());
        param = new SequenceEntity();
        mapper.insertTeaSequence(param);
        System.out.println(param.getSeq());
        param = new SequenceEntity();
        mapper.insertPurchaseOrderSequence(param);
        System.out.println(param.getSeq());
        param = new SequenceEntity();
        mapper.insertReturnOrderSequence(param);
        System.out.println(param.getSeq());
    }

}
