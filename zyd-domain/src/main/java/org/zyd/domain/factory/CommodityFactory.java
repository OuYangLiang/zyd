package org.zyd.domain.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.zyd.domain.bean.BoutiqueBean;
import org.zyd.domain.bean.CommodityBean;
import org.zyd.domain.bean.CommodityEnquiringBean;
import org.zyd.domain.bean.CommodityImageBean;
import org.zyd.domain.bean.CommodityPropertyBean;
import org.zyd.domain.bean.ItemListBean;
import org.zyd.domain.bean.LabelBean;
import org.zyd.domain.bean.PropertyConfigBean;
import org.zyd.domain.bean.TeaBean;
import org.zyd.domain.bean.TeapotBean;
import org.zyd.domain.bean.impl.BoutiqueBeanImpl;
import org.zyd.domain.bean.impl.CommodityBeanImpl;
import org.zyd.domain.bean.impl.CommodityEnquiringBeanImpl;
import org.zyd.domain.bean.impl.CommodityImageBeanImpl;
import org.zyd.domain.bean.impl.CommodityPropertyBeanImpl;
import org.zyd.domain.bean.impl.ItemListBeanImpl;
import org.zyd.domain.bean.impl.LabelBeanImpl;
import org.zyd.domain.bean.impl.PropertyConfigBeanImpl;
import org.zyd.domain.bean.impl.TeaBeanImpl;
import org.zyd.domain.bean.impl.TeapotBeanImpl;
import org.zyd.store.entity.BoutiqueEntity;
import org.zyd.store.entity.CommodityEnquiringEntity;
import org.zyd.store.entity.CommodityEntity;
import org.zyd.store.entity.CommodityImageEntity;
import org.zyd.store.entity.CommodityPropertyEntity;
import org.zyd.store.entity.ItemListEntity;
import org.zyd.store.entity.LabelEntity;
import org.zyd.store.entity.PropertyConfigEntity;
import org.zyd.store.entity.TeaEntity;
import org.zyd.store.entity.TeapotEntity;

public class CommodityFactory implements ApplicationContextAware {
    private ApplicationContext context;

    public CommodityBean createCommodityBean() {
        return this.createCommodityBean(null);
    }

    public CommodityBean createCommodityBean(CommodityEntity entity) {
        CommodityBeanImpl rlt = new CommodityBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public TeapotBean createTeapotBean() {
        return this.createTeapotBean(null, null);
    }

    public TeapotBean createTeapotBean(CommodityEntity cmmdty, TeapotEntity entity) {
        TeapotBeanImpl rlt = new TeapotBeanImpl(cmmdty, entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public BoutiqueBean createBoutiqueBean() {
        return this.createBoutiqueBean(null, null);
    }

    public BoutiqueBean createBoutiqueBean(CommodityEntity cmmdty, BoutiqueEntity entity) {
        BoutiqueBeanImpl rlt = new BoutiqueBeanImpl(cmmdty, entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public TeaBean createTeaBean() {
        return this.createTeaBean(null, null);
    }

    public TeaBean createTeaBean(CommodityEntity cmmdty, TeaEntity entity) {
        TeaBeanImpl rlt = new TeaBeanImpl(cmmdty, entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public CommodityImageBean createCommodityImageBean() {
        return this.createCommodityImageBean(null);
    }

    public CommodityImageBean createCommodityImageBean(CommodityImageEntity entity) {
        CommodityImageBeanImpl rlt = new CommodityImageBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public ItemListBean createItemListBean() {
        return this.createItemListBean(null);
    }

    public ItemListBean createItemListBean(ItemListEntity entity) {
        ItemListBeanImpl rlt = new ItemListBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public CommodityPropertyBean createCommodityPropertyBean() {
        return this.createCommodityPropertyBean(null);
    }

    public CommodityPropertyBean createCommodityPropertyBean(CommodityPropertyEntity entity) {
        CommodityPropertyBeanImpl rlt = new CommodityPropertyBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public PropertyConfigBean createPropertyConfigBean() {
        return this.createPropertyConfigBean(null);
    }

    public PropertyConfigBean createPropertyConfigBean(PropertyConfigEntity entity) {
        PropertyConfigBeanImpl rlt = new PropertyConfigBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public CommodityEnquiringBean createCommodityEnquiringBean() {
        return this.createCommodityEnquiringBean(null);
    }

    public CommodityEnquiringBean createCommodityEnquiringBean(CommodityEnquiringEntity entity) {
        CommodityEnquiringBeanImpl rlt = new CommodityEnquiringBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public LabelBean createLabelBean() {
        return this.createLabelBean(null);
    }

    public LabelBean createLabelBean(LabelEntity entity) {
        LabelBeanImpl rlt = new LabelBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }
}
