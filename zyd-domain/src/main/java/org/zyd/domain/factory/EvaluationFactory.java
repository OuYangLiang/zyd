package org.zyd.domain.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.zyd.domain.bean.AddedEvaluationBean;
import org.zyd.domain.bean.CommodityEvaluationBean;
import org.zyd.domain.bean.EvaluationImageBean;
import org.zyd.domain.bean.EvaluationLabelBean;
import org.zyd.domain.bean.impl.AddedEvaluationBeanImpl;
import org.zyd.domain.bean.impl.CommodityEvaluationBeanImpl;
import org.zyd.domain.bean.impl.EvaluationImageBeanImpl;
import org.zyd.domain.bean.impl.EvaluationLabelBeanImpl;
import org.zyd.store.entity.AddedEvaluationEntity;
import org.zyd.store.entity.CommodityEvaluationEntity;
import org.zyd.store.entity.EvaluationImageEntity;
import org.zyd.store.entity.EvaluationLabelEntity;

public class EvaluationFactory implements ApplicationContextAware {
    private ApplicationContext context;

    public CommodityEvaluationBean createCommodityEvaluationBean() {
        return this.createCommodityEvaluationBean(null);
    }

    public CommodityEvaluationBean createCommodityEvaluationBean(CommodityEvaluationEntity entity) {
        CommodityEvaluationBeanImpl rlt = new CommodityEvaluationBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public EvaluationImageBean createEvaluationImageBean() {
        return this.createEvaluationImageBean(null);
    }

    public EvaluationImageBean createEvaluationImageBean(EvaluationImageEntity entity) {
        EvaluationImageBeanImpl rlt = new EvaluationImageBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public AddedEvaluationBean createAddedEvaluationBean() {
        return this.createAddedEvaluationBean(null);
    }

    public AddedEvaluationBean createAddedEvaluationBean(AddedEvaluationEntity entity) {
        AddedEvaluationBeanImpl rlt = new AddedEvaluationBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public EvaluationLabelBean createEvaluationLabelBean() {
        return this.createEvaluationLabelBean(null);
    }

    public EvaluationLabelBean createEvaluationLabelBean(EvaluationLabelEntity entity) {
        EvaluationLabelBeanImpl rlt = new EvaluationLabelBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }
}
