package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.zyd.common.constants.Category;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.BoutiqueBean;
import org.zyd.domain.bean.CommodityImageBean;
import org.zyd.domain.bean.CommodityPropertyBean;
import org.zyd.domain.bean.ItemListBean;
import org.zyd.domain.bean.LabelBean;
import org.zyd.domain.util.SequenceGenerator;
import org.zyd.store.entity.BoutiqueEntity;
import org.zyd.store.entity.CommodityEntity;
import org.zyd.store.mapper.BoutiqueMapper;
import org.zyd.store.mapper.PendingBoutiqueMapper;

public class BoutiqueBeanImpl extends CommodityBeanImpl implements BoutiqueBean {

    private BoutiqueEntity entity;

    @Autowired
    private BoutiqueMapper boutiqueMapper;
    @Autowired
    private PendingBoutiqueMapper pendingBoutiqueMapper;
    @Autowired
    private SequenceGenerator sequenceGenerator;

    public BoutiqueBeanImpl(CommodityEntity commodityEntity, BoutiqueEntity boutiqueEntity) {
        super(commodityEntity);
        this.entity = boutiqueEntity;
    }

    @Override
    public BigDecimal getCmmdtyId() {
        if (null == entity) {
            return null;
        }
        return entity.getCmmdtyId();
    }

    @Override
    public Category getCategory() {
        if (null == entity) {
            return null;
        }
        return Category.valueOf(entity.getCategory());
    }

    @Override
    public String getCmmdtyName() {
        if (null == entity) {
            return null;
        }
        return entity.getCmmdtyName();
    }

    @Override
    public String getCmmdtyNum() {
        if (null == entity) {
            return null;
        }
        return entity.getCmmdtyNum();
    }

    @Override
    public String getCmmdtyDesc() {
        if (null == entity) {
            return null;
        }
        return entity.getCmmdtyDesc();
    }

    @Override
    public Integer getNumStored() {
        if (null == entity) {
            return null;
        }
        return entity.getNumStored();
    }

    @Override
    public Integer getNumSales() {
        if (null == entity) {
            return null;
        }
        return entity.getNumSales();
    }

    @Override
    public Integer getNumEvaluated() {
        if (null == entity) {
            return null;
        }
        return entity.getNumEvaluated();
    }

    @Override
    public BigDecimal getProposedPrice() {
        if (null == entity) {
            return null;
        }
        return entity.getProposedPrice();
    }

    @Override
    public BigDecimal getCurrentPrice() {
        if (null == entity) {
            return null;
        }
        return entity.getCurrentPrice();
    }

    @Override
    public Date getShelvesTime() {
        if (null == entity) {
            return null;
        }
        return entity.getShelvesTime();
    }

    @Override
    public Date getUnshelvesTime() {
        if (null == entity) {
            return null;
        }
        return entity.getUnshelvesTime();
    }

    @Override
    public String getDefaultImageAddrs() {
        if (null == entity) {
            return null;
        }
        return entity.getDefaultImageAddrs();
    }

    @Override
    public void setCmmdtyId(BigDecimal cmmdtyId) {
        super.setCmmdtyId(cmmdtyId);

        if (null == entity) {
            entity = new BoutiqueEntity();
        }
        entity.setCmmdtyId(cmmdtyId);
    }

    @Override
    public void setCategory(Category category) {
        super.setCategory(category);

        if (null == entity) {
            entity = new BoutiqueEntity();
        }
        entity.setCategory(category.name());
    }

    @Override
    public void setCmmdtyName(String cmmdtyName) {
        if (null == entity) {
            entity = new BoutiqueEntity();
        }
        entity.setCmmdtyName(cmmdtyName);
    }

    @Override
    public void setCmmdtyNum(String cmmdtyNum) {
        if (null == entity) {
            entity = new BoutiqueEntity();
        }
        entity.setCmmdtyNum(cmmdtyNum);
    }

    @Override
    public void setCmmdtyDesc(String cmmdtyDesc) {
        if (null == entity) {
            entity = new BoutiqueEntity();
        }
        entity.setCmmdtyDesc(cmmdtyDesc);
    }

    @Override
    public void setNumStored(Integer numStored) {
        if (null == entity) {
            entity = new BoutiqueEntity();
        }
        entity.setNumStored(numStored);
    }

    @Override
    public void setNumSales(Integer numSales) {
        if (null == entity) {
            entity = new BoutiqueEntity();
        }
        entity.setNumSales(numSales);
    }

    @Override
    public void setNumEvaluated(Integer numEvaluated) {
        if (null == entity) {
            entity = new BoutiqueEntity();
        }
        entity.setNumEvaluated(numEvaluated);
    }

    @Override
    public void setProposedPrice(BigDecimal proposedPrice) {
        if (null == entity) {
            entity = new BoutiqueEntity();
        }
        entity.setProposedPrice(proposedPrice);
    }

    @Override
    public void setCurrentPrice(BigDecimal currentPrice) {
        if (null == entity) {
            entity = new BoutiqueEntity();
        }
        entity.setCurrentPrice(currentPrice);
    }

    @Override
    public void setShelvesTime(Date shelvesTime) {
        if (null == entity) {
            entity = new BoutiqueEntity();
        }
        entity.setShelvesTime(shelvesTime);
    }

    @Override
    public void setUnshelvesTime(Date unshelvesTime) {
        if (null == entity) {
            entity = new BoutiqueEntity();
        }
        entity.setUnshelvesTime(unshelvesTime);
    }

    @Override
    public void setDefaultImageAddrs(String defaultImageAddrs) {
        if (null == entity) {
            entity = new BoutiqueEntity();
        }
        entity.setDefaultImageAddrs(defaultImageAddrs);
    }

    @Override
    public void saveRecursively() throws ZydException {
        this.save();
        BigDecimal cmmdtyId = this.getCmmdtyId();

        if (null == cmmdtyId)
            throw new ZydException(ErrorCode.EZYD0002);
        // 包装清单
        List<ItemListBean> itemListBeans = this.getItemListBeans();
        if (!CollectionUtils.isEmpty(itemListBeans)) {
            for (ItemListBean item : itemListBeans) {
                item.setCmmdtyId(cmmdtyId);
                item.save();
            }
        }
        // 图片
        List<CommodityImageBean> commodityImageBeans = this.getCommodityImageBeans();
        if (!CollectionUtils.isEmpty(commodityImageBeans)) {
            for (CommodityImageBean image : commodityImageBeans) {
                image.setCmmdtyId(cmmdtyId);
                image.save();
            }
        }
        // 详情图片
        List<CommodityImageBean> detailImageBeans = this.getDetailImageBeans();
        if (!CollectionUtils.isEmpty(detailImageBeans)) {
            for (CommodityImageBean image : detailImageBeans) {
                image.setCmmdtyId(cmmdtyId);
                image.save();
            }
        }
        // 商品属性
        List<CommodityPropertyBean> commodityPropertyBeans = this.getCommodityPropertyBeans();
        if (!CollectionUtils.isEmpty(commodityPropertyBeans)) {
            for (CommodityPropertyBean pro : commodityPropertyBeans) {
                pro.setCmmdtyId(cmmdtyId);
                pro.save();
            }
        }
        // 标签
        LabelBean labelBean = this.getLabelBean();
        if (null != labelBean) {
            labelBean.save();

            this.setLabel(labelBean.getLabelId());
        }

    }

    @Override
    public void save() throws ZydException {
        try {
            super.save();
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);
            this.setCmmdtyId(super.getCmmdtyId());
            this.setCmmdtyNum(sequenceGenerator.generateBoutiqueCmmdtyNum());
            pendingBoutiqueMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void change() throws ZydException {
        try {
            super.change();
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            if (StringUtils.isEmpty(this.getAuditor())) {
                // 未审核
                pendingBoutiqueMapper.updateBySelective(this.entity);
            } else {
                boutiqueMapper.updateBySelective(this.entity);
                pendingBoutiqueMapper.updateBySelective(this.entity);
            }
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void remove() throws ZydException {
        try {
            if (StringUtils.isEmpty(this.getAuditor())) {
                // 未审核
                pendingBoutiqueMapper.delete(this.entity);
            } else {
                boutiqueMapper.delete(this.entity);
                pendingBoutiqueMapper.delete(this.entity);
            }
            super.remove();
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setCmmdtyId(null);
            super.setCmmdtyId(null);
        }
    }

	@Override
	public Integer getNumEnquired() {
		if (null == entity) {
			return null;
		}
		return entity.getNumSales();
	}

	@Override
	public void setNumEnquired(Integer numEnquired) {
		if (null == entity) {
            entity = new BoutiqueEntity();
        }
		entity.setNumEnquired(numEnquired);
	}

}
