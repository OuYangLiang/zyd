package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.zyd.common.constants.Category;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.SalesMode;
import org.zyd.common.constants.TeapotLevel;
import org.zyd.common.constants.TeapotMaterial;
import org.zyd.common.constants.TeapotPriceRegion;
import org.zyd.common.constants.TeapotShape;
import org.zyd.common.constants.TeapotType;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.CommodityImageBean;
import org.zyd.domain.bean.CommodityPropertyBean;
import org.zyd.domain.bean.ItemListBean;
import org.zyd.domain.bean.LabelBean;
import org.zyd.domain.bean.TeapotBean;
import org.zyd.domain.util.SequenceGenerator;
import org.zyd.store.entity.CommodityEntity;
import org.zyd.store.entity.TeapotEntity;
import org.zyd.store.mapper.PendingTeapotMapper;
import org.zyd.store.mapper.TeapotMapper;

public class TeapotBeanImpl extends CommodityBeanImpl implements TeapotBean {

    private TeapotEntity entity;

    @Autowired
    private TeapotMapper teapotMapper;
    @Autowired
    private PendingTeapotMapper pendingTeapotMapper;
    @Autowired
    private SequenceGenerator sequenceGenerator;

    public TeapotBeanImpl(CommodityEntity commodityEntity, TeapotEntity teapotEntity) {
        super(commodityEntity);
        this.entity = teapotEntity;
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
        if (StringUtils.isEmpty(entity.getCategory())) {
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
    public TeapotType getType() {
        if (null == entity) {
            return null;
        }
        if (StringUtils.isEmpty(entity.getType())) {
            return null;
        }
        return TeapotType.valueOf(entity.getType());
    }

    @Override
    public TeapotShape getShape() {
        if (null == entity) {
            return null;
        }
        if (StringUtils.isEmpty(entity.getShape())) {
            return null;
        }
        return TeapotShape.valueOf(entity.getShape());
    }

    @Override
    public TeapotMaterial getMaterial() {
        if (null == entity) {
            return null;
        }
        if (StringUtils.isEmpty(entity.getMaterial())) {
            return null;
        }
        return TeapotMaterial.valueOf(entity.getMaterial());
    }

    @Override
    public Integer getSize() {
        if (null == entity) {
            return null;
        }
        return entity.getSize();
    }

    @Override
    public TeapotLevel getLevel() {
        if (null == entity) {
            return null;
        }
        if (StringUtils.isEmpty(entity.getLevel())) {
            return null;
        }
        return TeapotLevel.valueOf(entity.getLevel());
    }

    @Override
    public String getProducer() {
        if (null == entity) {
            return null;
        }
        return entity.getProducer();
    }

    @Override
    public SalesMode getSalesMode() {
        if (null == entity) {
            return null;
        }
        if (StringUtils.isEmpty(entity.getSalesMode())) {
            return null;
        }
        return SalesMode.valueOf(entity.getSalesMode());
    }

    @Override
    public TeapotPriceRegion getPriceRegion() {
        if (null == entity) {
            return null;
        }
        if (StringUtils.isEmpty(entity.getPriceRegion())) {
            return null;
        }
        return TeapotPriceRegion.valueOf(entity.getPriceRegion());
    }

    @Override
    public void setCmmdtyId(BigDecimal cmmdtyId) {
        super.setCmmdtyId(cmmdtyId);

        if (null == entity) {
            entity = new TeapotEntity();
        }
        entity.setCmmdtyId(cmmdtyId);
    }

    @Override
    public void setCategory(Category category) {
        super.setCategory(category);

        if (null == entity) {
            entity = new TeapotEntity();
        }
        entity.setCategory(category.name());
    }

    @Override
    public void setCmmdtyName(String cmmdtyName) {
        if (null == entity) {
            entity = new TeapotEntity();
        }
        entity.setCmmdtyName(cmmdtyName);
    }

    @Override
    public void setCmmdtyNum(String cmmdtyNum) {
        if (null == entity) {
            entity = new TeapotEntity();
        }
        entity.setCmmdtyNum(cmmdtyNum);
    }

    @Override
    public void setCmmdtyDesc(String cmmdtyDesc) {
        if (null == entity) {
            entity = new TeapotEntity();
        }
        entity.setCmmdtyDesc(cmmdtyDesc);
    }

    @Override
    public void setNumStored(Integer numStored) {
        if (null == entity) {
            entity = new TeapotEntity();
        }
        entity.setNumStored(numStored);
    }

    @Override
    public void setNumSales(Integer numSales) {
        if (null == entity) {
            entity = new TeapotEntity();
        }
        entity.setNumSales(numSales);
    }

    @Override
    public void setNumEvaluated(Integer numEvaluated) {
        if (null == entity) {
            entity = new TeapotEntity();
        }
        entity.setNumEvaluated(numEvaluated);
    }

    @Override
    public void setProposedPrice(BigDecimal proposedPrice) {
        if (null == entity) {
            entity = new TeapotEntity();
        }
        entity.setProposedPrice(proposedPrice);
    }

    @Override
    public void setCurrentPrice(BigDecimal currentPrice) {
        if (null == entity) {
            entity = new TeapotEntity();
        }
        entity.setCurrentPrice(currentPrice);
    }

    @Override
    public void setShelvesTime(Date shelvesTime) {
        if (null == entity) {
            entity = new TeapotEntity();
        }
        entity.setShelvesTime(shelvesTime);
    }

    @Override
    public void setUnshelvesTime(Date unshelvesTime) {
        if (null == entity) {
            entity = new TeapotEntity();
        }
        entity.setUnshelvesTime(unshelvesTime);
    }

    @Override
    public void setDefaultImageAddrs(String defaultImageAddrs) {
        if (null == entity) {
            entity = new TeapotEntity();
        }
        entity.setDefaultImageAddrs(defaultImageAddrs);
    }

    @Override
    public void setType(TeapotType type) {
        if (null == entity) {
            entity = new TeapotEntity();
        }
        entity.setType(type == null ? null : type.name());
    }

    @Override
    public void setShape(TeapotShape shape) {
        if (null == entity) {
            entity = new TeapotEntity();
        }
        entity.setShape(shape == null ? null : shape.name());
    }

    @Override
    public void setMaterial(TeapotMaterial material) {
        if (null == entity) {
            entity = new TeapotEntity();
        }
        entity.setMaterial(material == null ? null : material.name());
    }

    @Override
    public void setSize(Integer size) {
        if (null == entity) {
            entity = new TeapotEntity();
        }
        entity.setSize(size);
    }

    @Override
    public void setLevel(TeapotLevel level) {
        if (null == entity) {
            entity = new TeapotEntity();
        }
        entity.setLevel(level == null ? null : level.name());
    }

    @Override
    public void setProducer(String producer) {
        if (null == entity) {
            entity = new TeapotEntity();
        }
        entity.setProducer(producer);
    }

    @Override
    public void setSalesMode(SalesMode salesMode) {
        if (null == entity) {
            entity = new TeapotEntity();
        }
        entity.setSalesMode(salesMode == null ? null : salesMode.name());
    }

    @Override
    public void setPriceRegion(TeapotPriceRegion priceRegion) {
        if (null == entity) {
            entity = new TeapotEntity();
        }
        entity.setPriceRegion(priceRegion == null ? null : priceRegion.name());
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
            this.setCmmdtyNum(sequenceGenerator.generateTeapotCmmdtyNum());
            pendingTeapotMapper.insert(this.entity);
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
                pendingTeapotMapper.updateBySelective(this.entity);
            } else {
                teapotMapper.updateBySelective(this.entity);
                pendingTeapotMapper.updateBySelective(this.entity);
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
                pendingTeapotMapper.delete(this.entity);
            } else {
                teapotMapper.delete(this.entity);
                pendingTeapotMapper.delete(this.entity);
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
		return entity.getNumEnquired();
	}

	@Override
	public void setNumEnquired(Integer numEnquired) {
		if (null == entity) {
			entity = new TeapotEntity();
		}
		entity.setNumEnquired(numEnquired);
	}

}
