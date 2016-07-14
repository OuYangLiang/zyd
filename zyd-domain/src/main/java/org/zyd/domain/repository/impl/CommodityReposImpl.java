package org.zyd.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.zyd.common.constants.Category;
import org.zyd.common.constants.CommodityImageType;
import org.zyd.common.constants.CommoditySortCriteria;
import org.zyd.common.constants.CommonConstants;
import org.zyd.common.constants.LabelStyle;
import org.zyd.common.constants.SortCriteria;
import org.zyd.common.exception.ZydException;
import org.zyd.common.vo.BoutiqueSearchVo;
import org.zyd.common.vo.TeaSearchVo;
import org.zyd.common.vo.TeapotSearchVo;
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
import org.zyd.domain.factory.CommodityFactory;
import org.zyd.domain.repository.CommodityRepos;
import org.zyd.store.entity.BoutiqueEntity;
import org.zyd.store.entity.CollectedListEntity;
import org.zyd.store.entity.CommodityEnquiringEntity;
import org.zyd.store.entity.CommodityEntity;
import org.zyd.store.entity.CommodityImageEntity;
import org.zyd.store.entity.CommodityLabelRelEntity;
import org.zyd.store.entity.CommodityPropertyEntity;
import org.zyd.store.entity.GiftContainingEntity;
import org.zyd.store.entity.GiftEntity;
import org.zyd.store.entity.ItemListEntity;
import org.zyd.store.entity.LabelEntity;
import org.zyd.store.entity.PropertyConfigEntity;
import org.zyd.store.entity.RecommendedCommodityEntity;
import org.zyd.store.entity.TeaEntity;
import org.zyd.store.entity.TeapotEntity;
import org.zyd.store.mapper.BoutiqueMapper;
import org.zyd.store.mapper.CollectedListMapper;
import org.zyd.store.mapper.CommodityEnquiringMapper;
import org.zyd.store.mapper.CommodityImageMapper;
import org.zyd.store.mapper.CommodityLabelRelMapper;
import org.zyd.store.mapper.CommodityMapper;
import org.zyd.store.mapper.CommodityPropertyMapper;
import org.zyd.store.mapper.GiftContainingMapper;
import org.zyd.store.mapper.GiftMapper;
import org.zyd.store.mapper.ItemListMapper;
import org.zyd.store.mapper.LabelMapper;
import org.zyd.store.mapper.PropertyConfigMapper;
import org.zyd.store.mapper.RecommendedCommodityMapper;
import org.zyd.store.mapper.TeaMapper;
import org.zyd.store.mapper.TeapotMapper;
import org.zyd.store.term.BoutiqueTerm;
import org.zyd.store.term.CollectedListTerm;
import org.zyd.store.term.CommodityEnquiringTerm;
import org.zyd.store.term.CommodityImageTerm;
import org.zyd.store.term.CommodityLabelRelTerm;
import org.zyd.store.term.CommodityPropertyTerm;
import org.zyd.store.term.CommodityTerm;
import org.zyd.store.term.GiftContainingTerm;
import org.zyd.store.term.GiftTerm;
import org.zyd.store.term.ItemListTerm;
import org.zyd.store.term.LabelTerm;
import org.zyd.store.term.PropertyConfigTerm;
import org.zyd.store.term.RecommendedCommodityTerm;
import org.zyd.store.term.TeaTerm;
import org.zyd.store.term.TeapotTerm;

public class CommodityReposImpl implements CommodityRepos {

    @Autowired
    private CollectedListMapper collectedListMapper;
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private TeapotMapper teapotMapper;
    @Autowired
    private BoutiqueMapper boutiqueMapper;
    @Autowired
    private TeaMapper teaMapper;
    @Autowired
    private CommodityImageMapper commodityImageMapper;
    @Autowired
    private ItemListMapper itemListMapper;
    @Autowired
    private CommodityPropertyMapper commodityPropertyMapper;
    @Autowired
    private PropertyConfigMapper propertyConfigMapper;
    @Autowired
    private CommodityEnquiringMapper commodityEnquiringMapper;
    @Autowired
    private CommodityLabelRelMapper commodityLabelRelMapper;
    @Autowired
    private GiftMapper giftMapper;
    @Autowired
    private GiftContainingMapper giftContainingMapper;
    @Autowired
    private LabelMapper labelMapper;
    @Autowired
    private RecommendedCommodityMapper recommendedCommodityMapper;
    @Autowired
    private CommodityFactory commodityFactory;

    @Override
    public List<CommodityBean> queryCollectedCommoditiesByParty(BigDecimal partyId, int pageSize, int page)
            throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        CollectedListTerm term = new CollectedListTerm();
        term.setPartyId(partyId);
        term.setPage(page);
        term.setPageSize(pageSize);
        term.setSortField(SortCriteria.collected_list_collected_time_desc.getField());
        term.setSortDir(SortCriteria.collected_list_collected_time_desc.getDir());
        List<CollectedListEntity> entitys = collectedListMapper.listOfSummary(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<CommodityBean> rlt = new ArrayList<CommodityBean>();
        for (CollectedListEntity entity : entitys) {
            rlt.add(queryCommodityByKey(entity.getCmmdtyId()));
        }
        return rlt;
    }

    @Override
    public CommodityBean queryCommodityByKey(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        CommodityTerm cmmdty = new CommodityTerm();
        cmmdty.setCmmdtyId(cmmdtyId);
        List<CommodityEntity> entitys = commodityMapper.select(cmmdty);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        CommodityEntity cmmdtyEntity = entitys.get(0);
        if (Category.A2100010.name().equals(cmmdtyEntity.getCategory())) {
            TeapotTerm term = new TeapotTerm();
            term.setCmmdtyId(cmmdtyId);
            List<TeapotEntity> teapots = teapotMapper.select(term);
            if (!CollectionUtils.isEmpty(teapots)) {
                return (CommodityBean) commodityFactory.createTeapotBean(cmmdtyEntity, teapots.get(0));
            }
        } else if (Category.A2100050.name().equals(cmmdtyEntity.getCategory())) {
            TeaTerm term = new TeaTerm();
            term.setCmmdtyId(cmmdtyId);
            List<TeaEntity> teas = teaMapper.select(term);
            if (!CollectionUtils.isEmpty(teas)) {
                return (CommodityBean) commodityFactory.createTeaBean(cmmdtyEntity, teas.get(0));
            }
        } else {
            BoutiqueTerm term = new BoutiqueTerm();
            term.setCmmdtyId(cmmdtyId);
            List<BoutiqueEntity> boutiques = boutiqueMapper.select(term);
            if (!CollectionUtils.isEmpty(boutiques)) {
                return (CommodityBean) commodityFactory.createBoutiqueBean(cmmdtyEntity, boutiques.get(0));
            }
        }
        return null;
    }

    @Override
    public CommodityBean queryCommodityByCmmdtyNum(String cmmdtyNum) throws ZydException {
        // 紫砂壶：H开头
        // 精品：G开头
        // 茶叶：C开头
        if (StringUtils.isEmpty(cmmdtyNum)) {
            throw new IllegalArgumentException();
        }
        if (cmmdtyNum.startsWith(CommonConstants.CMMDTY_NUM_PREFIX_H)) {
            TeapotTerm term = new TeapotTerm();
            term.setCmmdtyNum(cmmdtyNum);
            List<TeapotEntity> entitys = teapotMapper.select(term);
            if (!CollectionUtils.isEmpty(entitys)) {
                return (CommodityBean) commodityFactory.createTeapotBean(null, entitys.get(0));
            }
        } else if (cmmdtyNum.startsWith(CommonConstants.CMMDTY_NUM_PREFIX_G)) {
            BoutiqueTerm term = new BoutiqueTerm();
            term.setCmmdtyNum(cmmdtyNum);
            List<BoutiqueEntity> entitys = boutiqueMapper.select(term);
            if (!CollectionUtils.isEmpty(entitys)) {
                return (CommodityBean) commodityFactory.createBoutiqueBean(null, entitys.get(0));
            }
        } else if (cmmdtyNum.startsWith(CommonConstants.CMMDTY_NUM_PREFIX_C)) {
            TeaTerm term = new TeaTerm();
            term.setCmmdtyNum(cmmdtyNum);
            List<TeaEntity> entitys = teaMapper.select(term);
            if (!CollectionUtils.isEmpty(entitys)) {
                return (CommodityBean) commodityFactory.createTeaBean(null, entitys.get(0));
            }
        }

        throw new IllegalArgumentException("不合法的商品编码");
    }

    @Override
    public List<TeapotBean> queryTeapotBeans(TeapotSearchVo queryParam, CommoditySortCriteria criteria, int pageSize,
            int page) throws ZydException {
        if (null == queryParam) {
            throw new IllegalArgumentException();
        }
        TeapotTerm term = new TeapotTerm(); // TODO queryParam.toTerm();
        term.setCategory(queryParam.getCategory());
        term.setNumSales(queryParam.getNumSales());
        term.setNumEvaluated(queryParam.getNumEvaluated());
        term.setCurrentPrice(queryParam.getCurrentPrice());
        term.setShelvesTime(queryParam.getShelvesTime());
        term.setType(queryParam.getType());
        term.setShape(queryParam.getShape());
        term.setMaterial(queryParam.getMaterial());
        term.setSize(queryParam.getSize());
        term.setLevel(queryParam.getLevel());
        term.setPriceRegion(queryParam.getPriceRegion());

        term.setPage(page);
        term.setPageSize(pageSize);
        term.setSortField(criteria.getField());
        term.setSortDir(criteria.getDir());
        List<TeapotEntity> entitys = teapotMapper.listOfSummary(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<TeapotBean> rlt = new ArrayList<TeapotBean>();
        for (TeapotEntity entity : entitys) {
            rlt.add(commodityFactory.createTeapotBean(null, entity));
        }
        return rlt;
    }

    @Override
    public int queryCountOfTeapotBeans(TeapotSearchVo queryParam) throws ZydException {
        if (null == queryParam) {
            throw new IllegalArgumentException();
        }
        TeapotTerm term = new TeapotTerm();
        term.setCategory(queryParam.getCategory());
        term.setNumSales(queryParam.getNumSales());
        term.setNumEvaluated(queryParam.getNumEvaluated());
        term.setCurrentPrice(queryParam.getCurrentPrice());
        term.setShelvesTime(queryParam.getShelvesTime());
        term.setType(queryParam.getType());
        term.setShape(queryParam.getShape());
        term.setMaterial(queryParam.getMaterial());
        term.setSize(queryParam.getSize());
        term.setLevel(queryParam.getLevel());
        term.setPriceRegion(queryParam.getPriceRegion());
        
        return teapotMapper.countOfSummary(term);
    }

    @Override
    public List<BoutiqueBean> queryBoutiqueBeans(BoutiqueSearchVo queryParam, CommoditySortCriteria criteria,
            int pageSize, int page) throws ZydException {
        if (null == queryParam) {
            throw new IllegalArgumentException();
        }
        BoutiqueTerm term = new BoutiqueTerm(); // TODO queryParam.toTerm();
        term.setCategory(queryParam.getCategory());
        term.setCmmdtyNum(queryParam.getCmmdtyNum());
        term.setNumSales(queryParam.getNumSales());
        term.setCurrentPrice(queryParam.getCurrentPrice());
        term.setShelvesTime(queryParam.getShelvesTime());

        term.setPage(page);
        term.setPageSize(pageSize);
        term.setSortField(criteria.getField());
        term.setSortDir(criteria.getDir());
        List<BoutiqueEntity> entitys = boutiqueMapper.listOfSummary(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<BoutiqueBean> rlt = new ArrayList<BoutiqueBean>();
        for (BoutiqueEntity entity : entitys) {
            rlt.add(commodityFactory.createBoutiqueBean(null, entity));
        }
        return rlt;
    }

    @Override
    public List<TeaBean> queryTeaBeans(TeaSearchVo queryParam, CommoditySortCriteria criteria, int pageSize, int page)
            throws ZydException {
        if (null == queryParam) {
            throw new IllegalArgumentException();
        }
        TeaTerm term = new TeaTerm(); // TODO queryParam.toTerm();
        term.setCmmdtyNum(queryParam.getCmmdtyNum());
        term.setNumSales(queryParam.getNumSales());
        term.setCurrentPrice(queryParam.getCurrentPrice());
        term.setShelvesTime(queryParam.getShelvesTime());
        term.setTeaType(queryParam.getTeaType());
        term.setPlaceOfOrigin(queryParam.getPlaceOfOrigin());
        term.setLevel(queryParam.getLevel());
        term.setPacking(queryParam.getPacking());
        term.setPriceRegion(queryParam.getPriceRegion());

        term.setPage(page);
        term.setPageSize(pageSize);
        term.setSortField(criteria.getField());
        term.setSortDir(criteria.getDir());
        List<TeaEntity> entitys = teaMapper.listOfSummary(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<TeaBean> rlt = new ArrayList<TeaBean>();
        for (TeaEntity entity : entitys) {
            rlt.add(commodityFactory.createTeaBean(null, entity));
        }
        return rlt;
    }

    @Override
    public List<CommodityImageBean> queryCommodityImageBeans(BigDecimal cmmdtyId, CommodityImageType commodityImageType)
            throws ZydException {
        if (null == cmmdtyId || null == commodityImageType) {
            throw new IllegalArgumentException();
        }
        CommodityImageTerm term = new CommodityImageTerm();
        term.setCmmdtyId(cmmdtyId);
        term.setImageType(commodityImageType.name());
        term.setSortField(SortCriteria.commodity_image_image_seq_asc.getField());
        term.setSortDir(SortCriteria.commodity_image_image_seq_asc.getDir());
        List<CommodityImageEntity> entitys = commodityImageMapper.selectWithSort(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<CommodityImageBean> rlt = new ArrayList<CommodityImageBean>();
        for (CommodityImageEntity entity : entitys) {
            rlt.add(commodityFactory.createCommodityImageBean(entity));
        }
        return rlt;
    }

    @Override
    public List<ItemListBean> queryItemListBeans(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        ItemListTerm term = new ItemListTerm();
        term.setCmmdtyId(cmmdtyId);
        List<ItemListEntity> entitys = itemListMapper.listOfSummary(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<ItemListBean> rlt = new ArrayList<ItemListBean>();
        for (ItemListEntity entity : entitys) {
            rlt.add(commodityFactory.createItemListBean(entity));
        }
        return rlt;
    }

    @Override
    public ItemListBean queryItemListByKey(BigDecimal itemId) throws ZydException {
        if (null == itemId) {
            throw new IllegalArgumentException();
        }
        ItemListTerm term = new ItemListTerm();
        term.setItemId(itemId);
        List<ItemListEntity> entitys = itemListMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        return commodityFactory.createItemListBean(entitys.get(0));
    }

    @Override
    public ItemListBean queryItemListByDesc(BigDecimal cmmdtyId, String itemDesc) throws ZydException {
        if (null == cmmdtyId || StringUtils.isEmpty(itemDesc)) {
            throw new IllegalArgumentException();
        }
        ItemListTerm term = new ItemListTerm();
        term.setCmmdtyId(cmmdtyId);
        term.setItemDesc(itemDesc);
        List<ItemListEntity> entitys = itemListMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        return commodityFactory.createItemListBean(entitys.get(0));
    }

    @Override
    public List<CommodityPropertyBean> queryCommodityPropertyBeans(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        CommodityPropertyTerm term = new CommodityPropertyTerm();
        term.setCmmdtyId(cmmdtyId);
        term.setSortField(SortCriteria.commodity_property_seq_asc.getField());
        term.setSortDir(SortCriteria.commodity_property_seq_asc.getDir());
        List<CommodityPropertyEntity> entitys = commodityPropertyMapper.selectWithSort(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<CommodityPropertyBean> rlt = new ArrayList<CommodityPropertyBean>();
        for (CommodityPropertyEntity entity : entitys) {
            rlt.add(commodityFactory.createCommodityPropertyBean(entity));
        }
        return rlt;
    }

    @Override
    public CommodityPropertyBean queryCommodityPropertyByKey(BigDecimal propertyId) throws ZydException {
        if (null == propertyId) {
            throw new IllegalArgumentException();
        }
        CommodityPropertyTerm term = new CommodityPropertyTerm();
        term.setPropertyId(propertyId);
        List<CommodityPropertyEntity> entitys = commodityPropertyMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        return commodityFactory.createCommodityPropertyBean(entitys.get(0));
    }

    @Override
    public List<PropertyConfigBean> queryPropertyConfigBeansByCategory(Category category) throws ZydException {
        if (null == category) {
            throw new IllegalArgumentException();
        }
        PropertyConfigTerm term = new PropertyConfigTerm();
        term.setCategory(category.name());
        List<PropertyConfigEntity> entitys = propertyConfigMapper.listOfSummary(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<PropertyConfigBean> rlt = new ArrayList<PropertyConfigBean>();
        for (PropertyConfigEntity entity : entitys) {
            rlt.add(commodityFactory.createPropertyConfigBean(entity));
        }
        return rlt;
    }

    @Override
    public List<CommodityEnquiringBean> queryCommodityEnquiringBeansByParty(BigDecimal partyId, int pageSize, int page)
            throws ZydException {
        if (null == partyId) {
            return null;
        }
        CommodityEnquiringTerm term = new CommodityEnquiringTerm();
        term.setPartyId(partyId);
        term.setPage(page);
        term.setPageSize(pageSize);
        term.setSortField(SortCriteria.commodity_enquiring_event_ts_desc.getField());
        term.setSortDir(SortCriteria.commodity_enquiring_event_ts_desc.getDir());
        List<CommodityEnquiringEntity> entitys = commodityEnquiringMapper.listOfSummary(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<CommodityEnquiringBean> rlt = new ArrayList<CommodityEnquiringBean>();
        for (CommodityEnquiringEntity entity : entitys) {
            rlt.add(commodityFactory.createCommodityEnquiringBean(entity));
        }
        return rlt;
    }

    @Override
    public List<CommodityEnquiringBean> queryCommodityEnquiringBeansByCommodity(BigDecimal cmmdtyId, int pageSize,
            int page) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        CommodityEnquiringTerm term = new CommodityEnquiringTerm();
        term.setCmmdtyId(cmmdtyId);
        term.setPage(page);
        term.setPageSize(pageSize);
        term.setSortField(SortCriteria.commodity_enquiring_event_ts_desc.getField());
        term.setSortDir(SortCriteria.commodity_enquiring_event_ts_desc.getDir());
        List<CommodityEnquiringEntity> entitys = commodityEnquiringMapper.listOfSummary(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<CommodityEnquiringBean> rlt = new ArrayList<CommodityEnquiringBean>();
        for (CommodityEnquiringEntity entity : entitys) {
            rlt.add(commodityFactory.createCommodityEnquiringBean(entity));
        }
        return rlt;
    }

    @Override
    public CommodityEnquiringBean queryCommodityEnquiringBeansByKey(BigDecimal enquiringId) throws ZydException {
        if (null == enquiringId) {
            throw new IllegalArgumentException();
        }
        CommodityEnquiringTerm term = new CommodityEnquiringTerm();
        term.setEnquiringId(enquiringId);
        List<CommodityEnquiringEntity> entitys = commodityEnquiringMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        return commodityFactory.createCommodityEnquiringBean(entitys.get(0));
    }

    @Override
    public List<CommodityBean> queryGiftsByCommodity(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        GiftTerm giftTerm = new GiftTerm();
        giftTerm.setCmmdtyId(cmmdtyId);
        List<GiftEntity> entitys = giftMapper.select(giftTerm);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<CommodityBean> rlt = new ArrayList<CommodityBean>();
        for (GiftEntity entity : entitys) {
            GiftContainingTerm term = new GiftContainingTerm();
            term.setGiftId(entity.getGiftId());
            List<GiftContainingEntity> giftContainingEntitys = giftContainingMapper.select(term);
            if (CollectionUtils.isEmpty(giftContainingEntitys)) {
                continue;
            }
            rlt.add(queryCommodityByKey(giftContainingEntitys.get(0).getCmmdtyId()));
        }
        return rlt;
    }

    @Override
    public LabelBean queryLabelBeanByCommodity(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        CommodityLabelRelTerm term = new CommodityLabelRelTerm();
        term.setCmmdtyId(cmmdtyId);
        List<CommodityLabelRelEntity> entitys = commodityLabelRelMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        BigDecimal labelId = entitys.get(0).getLabelId();
        LabelTerm labelTerm = new LabelTerm();
        labelTerm.setLabelId(labelId);
        List<LabelEntity> labelEntitys = labelMapper.select(labelTerm);
        if (CollectionUtils.isEmpty(labelEntitys)) {
            return null;
        }
        return commodityFactory.createLabelBean(labelEntitys.get(0));
    }

    @Override
    public LabelBean queryLabelBeanByVal(LabelStyle labelStyle, String labelVal) throws ZydException {
        if (null == labelStyle || StringUtils.isEmpty(labelVal)) {
            throw new IllegalArgumentException();
        }
        LabelTerm term = new LabelTerm();
        term.setLabelStyle(labelStyle.name());
        term.setLabelVal(labelVal);
        List<LabelEntity> labelEntitys = labelMapper.select(term);
        if (CollectionUtils.isEmpty(labelEntitys)) {
            return null;
        }
        return commodityFactory.createLabelBean(labelEntitys.get(0));
    }

    @Override
    public LabelBean queryLabelBeanByKey(BigDecimal labelId) throws ZydException {
        if (null == labelId) {
            throw new IllegalArgumentException();
        }
        LabelTerm term = new LabelTerm();
        term.setLabelId(labelId);
        List<LabelEntity> labelEntitys = labelMapper.select(term);
        if (CollectionUtils.isEmpty(labelEntitys)) {
            return null;
        }
        return commodityFactory.createLabelBean(labelEntitys.get(0));
    }

    @Override
    public List<CommodityBean> queryRecommendedCommodityBeansByCommodity(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        RecommendedCommodityTerm term = new RecommendedCommodityTerm();
        term.setCmmdtyId(cmmdtyId);
        List<RecommendedCommodityEntity> entitys = recommendedCommodityMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<CommodityBean> rlt = new ArrayList<CommodityBean>();
        for (RecommendedCommodityEntity entity : entitys) {
            rlt.add(queryCommodityByKey(entity.getRecommendedCmmdtyId()));
        }
        return rlt;
    }

    @Override
    public TeapotBean queryTeapotByKey(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        TeapotTerm term = new TeapotTerm();
        term.setCmmdtyId(cmmdtyId);
        List<TeapotEntity> entitys = teapotMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        return commodityFactory.createTeapotBean(null, entitys.get(0));
    }

    @Override
    public BoutiqueBean queryBoutiqueByKey(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        BoutiqueTerm term = new BoutiqueTerm();
        term.setCmmdtyId(cmmdtyId);
        List<BoutiqueEntity> entitys = boutiqueMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        return commodityFactory.createBoutiqueBean(null, entitys.get(0));
    }

    @Override
    public TeaBean queryTeaByKey(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        TeaTerm term = new TeaTerm();
        term.setCmmdtyId(cmmdtyId);
        List<TeaEntity> entitys = teaMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        return commodityFactory.createTeaBean(null, entitys.get(0));
    }

    @Override
    public List<ItemListBean> queryCommodityItemList(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        ItemListTerm term = new ItemListTerm();
        term.setCmmdtyId(cmmdtyId);
        List<ItemListEntity> entitys = itemListMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<ItemListBean> rlt = new ArrayList<ItemListBean>();
        for (ItemListEntity entity : entitys) {
            rlt.add(commodityFactory.createItemListBean(entity));
        }
        return rlt;
    }

}
