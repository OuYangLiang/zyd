package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.zyd.common.constants.Category;
import org.zyd.common.constants.CommodityImageType;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.LabelStyle;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.CommodityBean;
import org.zyd.domain.bean.CommodityImageBean;
import org.zyd.domain.bean.CommodityPropertyBean;
import org.zyd.domain.bean.ItemListBean;
import org.zyd.domain.bean.LabelBean;
import org.zyd.domain.factory.CommodityFactory;
import org.zyd.store.entity.CommodityEntity;
import org.zyd.store.entity.CommodityImageEntity;
import org.zyd.store.entity.CommodityLabelRelEntity;
import org.zyd.store.entity.CommodityPropertyEntity;
import org.zyd.store.entity.GiftContainingEntity;
import org.zyd.store.entity.GiftEntity;
import org.zyd.store.entity.RecommendedCommodityEntity;
import org.zyd.store.mapper.BoutiqueMapper;
import org.zyd.store.mapper.CommodityImageMapper;
import org.zyd.store.mapper.CommodityLabelRelMapper;
import org.zyd.store.mapper.CommodityMapper;
import org.zyd.store.mapper.CommodityPropertyMapper;
import org.zyd.store.mapper.GiftContainingMapper;
import org.zyd.store.mapper.GiftMapper;
import org.zyd.store.mapper.ItemListMapper;
import org.zyd.store.mapper.RecommendedCommodityMapper;
import org.zyd.store.term.GiftContainingTerm;
import org.zyd.store.term.GiftTerm;
import org.zyd.store.term.RecommendedCommodityTerm;

public class CommodityBeanImpl implements CommodityBean {

    private CommodityEntity entity;
    private List<CommodityImageBean> commodityImageBeans;
    private List<CommodityImageBean> detailImageBeans;
    private List<ItemListBean> itemListBeans;
    private List<CommodityPropertyBean> commodityPropertyBeans;
    private LabelBean labelBean;
    private List<CommodityBean> gifts;
    private List<CommodityBean> recommendeds;

    @Autowired
    private BoutiqueMapper boutiqueMapper;
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private CommodityPropertyMapper commodityPropertyMapper;
    @Autowired
    private GiftMapper giftMapper;
    @Autowired
    private GiftContainingMapper giftContainingMapper;
    @Autowired
    private RecommendedCommodityMapper recommendedCommodityMapper;
    @Autowired
    private CommodityLabelRelMapper commodityLabelRelMapper;
    @Autowired
    private ItemListMapper itemListMapper;
    @Autowired
    private CommodityImageMapper commodityImageMapper;
    @Autowired
    private CommodityFactory commodityFactory;

    public CommodityBeanImpl(CommodityEntity entity) {
        this.entity = entity;
    }

    @Override
    public List<CommodityImageBean> getDetailImageBeans() {
        return this.detailImageBeans;
    }

    @Override
    public void setDetailImageBeans(List<CommodityImageBean> detailImageBeans) {
        this.detailImageBeans = detailImageBeans;
    }

    @Override
    public List<CommodityImageBean> getCommodityImageBeans() {
        return this.commodityImageBeans;
    }

    @Override
    public void setCommodityImageBeans(List<CommodityImageBean> commodityImageBeans) {
        this.commodityImageBeans = commodityImageBeans;
    }

    @Override
    public List<ItemListBean> getItemListBeans() {
        return this.itemListBeans;
    }

    @Override
    public void setItemListBeans(List<ItemListBean> itemListBeans) {
        this.itemListBeans = itemListBeans;
    }

    @Override
    public List<CommodityPropertyBean> getCommodityPropertyBeans() {
        return this.commodityPropertyBeans;
    }

    @Override
    public void setCommodityPropertyBeans(List<CommodityPropertyBean> commodityPropertyBeans) {
        this.commodityPropertyBeans = commodityPropertyBeans;
    }

    @Override
    public LabelBean getLabelBean() {
        return this.labelBean;
    }

    @Override
    public void setLabelBean(LabelBean labelBean) {
        this.labelBean = labelBean;
    }

    @Override
    public List<CommodityBean> getGifts() {
        return this.gifts;
    }

    @Override
    public void setGifts(List<CommodityBean> gifts) {
        this.gifts = gifts;
    }

    @Override
    public List<CommodityBean> getRecommendeds() {
        return this.recommendeds;
    }

    @Override
    public void setRecommendeds(List<CommodityBean> recommendeds) {
        this.recommendeds = recommendeds;
    }

    @Override
    public String getIntroducer() {
        if (null == entity) {
            return null;
        }
        return entity.getIntroducer();
    }

    @Override
    public String getAuditor() {
        if (null == entity) {
            return null;
        }
        return entity.getAuditor();
    }

    @Override
    public void setIntroducer(String introducer) {
        if (null == entity) {
            entity = new CommodityEntity();
        }
        entity.setIntroducer(introducer);
    }

    @Override
    public void setAuditor(String auditor) {
        if (null == entity) {
            entity = new CommodityEntity();
        }
        entity.setAuditor(auditor);
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
    public void setCmmdtyId(BigDecimal cmmdtyId) {
        if (null == entity) {
            entity = new CommodityEntity();
        }
        entity.setCmmdtyId(cmmdtyId);
    }

    @Override
    public void setCategory(Category category) {
        if (null == entity) {
            entity = new CommodityEntity();
        }
        entity.setCategory(category.name());
    }

    @Override
    public void saveRecursively() throws ZydException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            commodityMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            commodityMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void approve(String auditor) throws ZydException {
        // TODO Auto-generated method stub

    }

    @Override
    public void remove() throws ZydException {
        try {
            commodityMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setCmmdtyId(null);
        }
    }

    @Override
    public void addGift(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            GiftEntity entity = new GiftEntity();
            // 商品id
            entity.setCmmdtyId(this.getCmmdtyId());
            entity.setSeq(1);
            entity.setCreateTime(now);
            entity.setUpdateTime(now);
            giftMapper.insert(entity);

            if (null == entity.getGiftId()) {
                throw new ZydException(ErrorCode.EZYD0002);
            }
            GiftContainingEntity giftContaining = new GiftContainingEntity();
            giftContaining.setCmmdtyId(cmmdtyId);
            giftContaining.setGiftId(entity.getGiftId());
            giftContaining.setCreateTime(now);
            giftContaining.setUpdateTime(now);
            giftContainingMapper.insert(giftContaining);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public boolean isGiftContaining(BigDecimal giftCmmdtyId) throws ZydException {
        if (null == giftCmmdtyId) {
            throw new IllegalArgumentException();
        }
        try {
            GiftTerm term = new GiftTerm();
            term.setCmmdtyId(this.getCmmdtyId());
            List<GiftEntity> gifts = giftMapper.select(term);

            if (CollectionUtils.isEmpty(gifts)) {
                return false;
            }
            for (GiftEntity gift : gifts) {
                GiftContainingTerm giftContaining = new GiftContainingTerm();
                giftContaining.setCmmdtyId(giftCmmdtyId);
                giftContaining.setGiftId(gift.getGiftId());
                if (!CollectionUtils.isEmpty(giftContainingMapper.select(giftContaining))) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void removeGift(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        try {
            GiftTerm term = new GiftTerm();
            term.setCmmdtyId(this.getCmmdtyId());
            List<GiftEntity> gifts = giftMapper.select(term);

            if (CollectionUtils.isEmpty(gifts)) {
                throw new ZydException(ErrorCode.EZYD0005);
            }
            BigDecimal giftId = gifts.get(0).getGiftId();
            GiftContainingEntity giftContaining = new GiftContainingEntity();
            giftContaining.setGiftId(giftId);
            giftContainingMapper.deleteByGiftId(giftContaining);

            giftMapper.delete(gifts.get(0));
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void addRecommended(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            RecommendedCommodityEntity entity = new RecommendedCommodityEntity();
            entity.setCmmdtyId(this.getCmmdtyId());
            entity.setRecommendedCmmdtyId(cmmdtyId);
            entity.setSeq(1);
            entity.setCreateTime(now);
            entity.setUpdateTime(now);
            recommendedCommodityMapper.insert(entity);

        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public boolean isRecommendRel(BigDecimal recommendedCmmdtyId) throws ZydException {
        if (null == recommendedCmmdtyId) {
            throw new IllegalArgumentException();
        }
        try {
            RecommendedCommodityTerm term = new RecommendedCommodityTerm();
            term.setCmmdtyId(this.getCmmdtyId());
            term.setRecommendedCmmdtyId(recommendedCmmdtyId);
            if (CollectionUtils.isEmpty(recommendedCommodityMapper.select(term))) {
                return false;
            }
            return true;

        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void removeRecommended(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        try {
            RecommendedCommodityEntity entity = new RecommendedCommodityEntity();
            entity.setCmmdtyId(getCmmdtyId());
            entity.setRecommendedCmmdtyId(cmmdtyId);
            recommendedCommodityMapper.deleteByRecommendedCmmdtyId(entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void addProperty(String propName, String propVal, int seq) throws ZydException {
        if (StringUtils.isEmpty(propName) || StringUtils.isEmpty(propVal)) {
            throw new IllegalArgumentException();
        }
        CommodityPropertyBean bean = commodityFactory.createCommodityPropertyBean();
        bean.setCmmdtyId(getCmmdtyId());
        bean.setPropName(propName);
        bean.setPropVal(propVal);
        bean.setSeq(seq);
        bean.save();
    }

    @Override
    public void updateProperty(BigDecimal propertyId, String propVal) throws ZydException {
        if (null == propertyId || StringUtils.isEmpty(propVal)) {
            throw new IllegalArgumentException();
        }
        CommodityPropertyBean bean = commodityFactory.createCommodityPropertyBean();
        bean.setPropertyId(propertyId);
        bean.setPropVal(propVal);
        bean.change();
    }

    @Override
    public void updatePropertyPosition(BigDecimal propertyId, int seq) throws ZydException {
        if (null == propertyId) {
            throw new IllegalArgumentException();
        }
        CommodityPropertyBean bean = commodityFactory.createCommodityPropertyBean();
        bean.setPropertyId(propertyId);
        bean.setSeq(seq);
        bean.change();
    }

    @Override
    public void removeProperty(BigDecimal propertyId) throws ZydException {
        if (null == propertyId) {
            throw new IllegalArgumentException();
        }
        CommodityPropertyBean bean = commodityFactory.createCommodityPropertyBean();
        bean.setPropertyId(propertyId);
        bean.remove();
    }

    @Override
    public void addImage(CommodityImageType commodityImageType, String imageAddrs, int seq) throws ZydException {
        if (null == commodityImageType || StringUtils.isEmpty(imageAddrs)) {
            throw new IllegalArgumentException();
        }
        CommodityImageBean bean = commodityFactory.createCommodityImageBean();
        bean.setCmmdtyId(getCmmdtyId());
        bean.setImageType(commodityImageType);
        bean.setImageAddrs(imageAddrs);
        bean.setImageSeq(seq);
        bean.save();
    }

    @Override
    public void updateImagePosition(BigDecimal imageId, int seq) throws ZydException {
        if (null == imageId) {
            throw new IllegalArgumentException();
        }
        CommodityImageBean bean = commodityFactory.createCommodityImageBean();
        bean.setImageId(imageId);
        bean.setImageSeq(seq);
        bean.change();
    }

    @Override
    public void removeImage(BigDecimal imageId) throws ZydException {
        if (null == imageId) {
            throw new IllegalArgumentException();
        }
        CommodityImageBean bean = commodityFactory.createCommodityImageBean();
        bean.setImageId(imageId);
        bean.remove();
    }

    @Override
    public void cleanImageByType(CommodityImageType commodityImageType) throws ZydException {
        if (null == commodityImageType) {
            throw new IllegalArgumentException();
        }
        try {
            CommodityImageEntity entity = new CommodityImageEntity();
            entity.setCmmdtyId(this.getCmmdtyId());
            entity.setImageType(commodityImageType.name());
            commodityImageMapper.cleanImageByType(entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void setLabel(LabelStyle labelStyle, String labelVal) throws ZydException {
        if (null == labelStyle || StringUtils.isEmpty(labelVal)) {
            throw new IllegalArgumentException();
        }
        LabelBean bean = commodityFactory.createLabelBean();
        bean.setLabelStyle(labelStyle);
        bean.setLabelVal(labelVal);
        bean.save();

        this.setLabel(bean.getLabelId());
    }

    @Override
    public void setLabel(BigDecimal labelId) throws ZydException {
        if (null == labelId) {
            throw new IllegalArgumentException();
        }
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            CommodityLabelRelEntity entity = new CommodityLabelRelEntity();
            entity.setCmmdtyId(getCmmdtyId());
            entity.setLabelId(labelId);
            entity.setCreateTime(now);
            entity.setUpdateTime(now);
            commodityLabelRelMapper.insert(entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void removeLabel() throws ZydException {
        try {
            CommodityLabelRelEntity entity = new CommodityLabelRelEntity();
            entity.setCmmdtyId(getCmmdtyId());
            commodityLabelRelMapper.delete(entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void removeCmmdtyLabel(BigDecimal labelId) throws ZydException {
        if (null == labelId) {
            throw new IllegalArgumentException();
        }
        try {
            CommodityLabelRelEntity entity = new CommodityLabelRelEntity();
            entity.setCmmdtyId(getCmmdtyId());
            entity.setLabelId(labelId);
            commodityLabelRelMapper.deleteByCmmdtyIdAndLabelId(entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void cleanCommodityProperties() throws ZydException {
        try {
            CommodityPropertyEntity entity = new CommodityPropertyEntity();
            entity.setCmmdtyId(this.getCmmdtyId());

            commodityPropertyMapper.cleanCommodityProperties(entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void updateCommodityItemList(BigDecimal itemId, int qty) throws ZydException {
        if (null == itemId) {
            throw new IllegalArgumentException();
        }
        ItemListBean bean = commodityFactory.createItemListBean();
        bean.setItemId(itemId);
        bean.setItemQty(qty);
        bean.change();
    }

    @Override
    public void addCommodityItemList(String itemDesc, int qty) throws ZydException {
        if (StringUtils.isEmpty(itemDesc)) {
            throw new IllegalArgumentException();
        }
        ItemListBean bean = commodityFactory.createItemListBean();
        bean.setCmmdtyId(getCmmdtyId());
        bean.setItemDesc(itemDesc);
        bean.setItemQty(qty);
        bean.save();
    }

    @Override
    public void removeCommodityItemList(BigDecimal itemId) throws ZydException {
        if (null == itemId) {
            throw new IllegalArgumentException();
        }
        ItemListBean bean = commodityFactory.createItemListBean();
        bean.setItemId(itemId);
        bean.remove();
    }

}
