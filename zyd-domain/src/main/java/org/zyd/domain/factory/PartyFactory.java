package org.zyd.domain.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.zyd.domain.bean.PartyAccountBean;
import org.zyd.domain.bean.PartyContactInfoBean;
import org.zyd.domain.bean.PartyIdentifyBean;
import org.zyd.domain.bean.PartyInfoBean;
import org.zyd.domain.bean.PartyLevelBean;
import org.zyd.domain.bean.PartyPasswordBean;
import org.zyd.domain.bean.PartyPointBean;
import org.zyd.domain.bean.PointEventBean;
import org.zyd.domain.bean.ShoppingCartBean;
import org.zyd.domain.bean.ShoppingCartItemBean;
import org.zyd.domain.bean.impl.PartyAccountBeanImpl;
import org.zyd.domain.bean.impl.PartyContactInfoBeanImpl;
import org.zyd.domain.bean.impl.PartyIdentifyBeanImpl;
import org.zyd.domain.bean.impl.PartyInfoBeanImpl;
import org.zyd.domain.bean.impl.PartyLevelBeanImpl;
import org.zyd.domain.bean.impl.PartyPasswordBeanImpl;
import org.zyd.domain.bean.impl.PartyPointBeanImpl;
import org.zyd.domain.bean.impl.PointEventBeanImpl;
import org.zyd.domain.bean.impl.ShoppingCartBeanImpl;
import org.zyd.domain.bean.impl.ShoppingCartItemBeanImpl;
import org.zyd.store.entity.PartyAccountEntity;
import org.zyd.store.entity.PartyContactInfoEntity;
import org.zyd.store.entity.PartyIdentifyEntity;
import org.zyd.store.entity.PartyInfoEntity;
import org.zyd.store.entity.PartyLevelEntity;
import org.zyd.store.entity.PartyPasswordEntity;
import org.zyd.store.entity.PartyPointEntity;
import org.zyd.store.entity.PointEventEntity;
import org.zyd.store.entity.ShoppingCartEntity;

import com.google.gson.Gson;

public class PartyFactory implements ApplicationContextAware {
    private ApplicationContext context;

    public PartyIdentifyBean createPartyIdentifyBean() {
        return this.createPartyIdentifyBean(null);
    }

    public PartyIdentifyBean createPartyIdentifyBean(PartyIdentifyEntity entity) {
        PartyIdentifyBeanImpl rlt = new PartyIdentifyBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public PartyInfoBean createPartyInfoBean() {
        return this.createPartyInfoBean(null);
    }

    public PartyInfoBean createPartyInfoBean(PartyInfoEntity entity) {
        PartyInfoBeanImpl rlt = new PartyInfoBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public PartyContactInfoBean createPartyContactInfoBean() {
        return this.createPartyContactInfoBean(null);
    }

    public PartyContactInfoBean createPartyContactInfoBean(PartyContactInfoEntity entity) {
        PartyContactInfoBeanImpl rlt = new PartyContactInfoBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public PartyAccountBean createPartyAccountBean() {
        return this.createPartyAccountBean(null);
    }

    public PartyAccountBean createPartyAccountBean(PartyAccountEntity entity) {
        PartyAccountBeanImpl rlt = new PartyAccountBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }
    
    public PartyAccountBean createPartyAccountBeanFromJson(String json) {
    	PartyAccountBean rlt = new Gson().fromJson(json, PartyAccountBeanImpl.class);
    	context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public PartyPasswordBean createPartyPasswordBean() {
        return this.createPartyPasswordBean(null);
    }

    public PartyPasswordBean createPartyPasswordBean(PartyPasswordEntity entity) {
        PartyPasswordBeanImpl rlt = new PartyPasswordBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public PartyPointBean createPartyPointBean() {
        return this.createPartyPointBean(null);
    }

    public PartyPointBean createPartyPointBean(PartyPointEntity entity) {
        PartyPointBeanImpl rlt = new PartyPointBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public PointEventBean createPointEventBean() {
        return this.createPointEventBean(null);
    }

    public PointEventBean createPointEventBean(PointEventEntity entity) {
        PointEventBeanImpl rlt = new PointEventBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public PartyLevelBean createPartyLevelBean() {
        return this.createPartyLevelBean(null);
    }

    public PartyLevelBean createPartyLevelBean(PartyLevelEntity entity) {
        PartyLevelBeanImpl rlt = new PartyLevelBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public ShoppingCartBean createShoppingCartBean() {
        ShoppingCartBeanImpl rlt = new ShoppingCartBeanImpl();
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public ShoppingCartItemBean createShoppingCartItemBean() {
        return this.createShoppingCartItemBean(null);
    }

    public ShoppingCartItemBean createShoppingCartItemBean(ShoppingCartEntity entity) {
        ShoppingCartItemBeanImpl rlt = new ShoppingCartItemBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }
    
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }
}
