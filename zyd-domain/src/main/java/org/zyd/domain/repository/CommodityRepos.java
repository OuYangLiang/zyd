package org.zyd.domain.repository;

import java.math.BigDecimal;
import java.util.List;

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
import org.zyd.common.constants.Category;
import org.zyd.common.constants.CommodityImageType;
import org.zyd.common.constants.CommoditySortCriteria;
import org.zyd.common.constants.LabelStyle;
import org.zyd.common.exception.ZydException;
import org.zyd.common.vo.BoutiqueSearchVo;
import org.zyd.common.vo.TeaSearchVo;
import org.zyd.common.vo.TeapotSearchVo;

public interface CommodityRepos {

    /**
     * 根据会员id查询会员收藏商品，根据collected_time降序排序
     * 
     * @param partyId 会员id
     * @param pageSize 分页大小
     * @param page 查询页
     * @return 商品集合
     * @throws ZydException
     */
    List<CommodityBean> queryCollectedCommoditiesByParty(BigDecimal partyId, int pageSize, int page)
            throws ZydException;

    /**
     * 根据商品id查询商品
     * 
     * @param cmmdtyId 商品id
     * @return 商品
     * @throws ZydException
     */
    CommodityBean queryCommodityByKey(BigDecimal cmmdtyId) throws ZydException;

    /**
     * 根据商品id查询壶
     * 
     * @param cmmdtyId 商品id
     * @return 壶
     * @throws ZydException
     */
    TeapotBean queryTeapotByKey(BigDecimal cmmdtyId) throws ZydException;

    /**
     * 根据商品id查询精品
     * 
     * @param cmmdtyId 商品id
     * @return 精品
     * @throws ZydException
     */
    BoutiqueBean queryBoutiqueByKey(BigDecimal cmmdtyId) throws ZydException;

    /**
     * 根据商品id查询茶
     * 
     * @param cmmdtyId 商品id
     * @return 茶
     * @throws ZydException
     */
    TeaBean queryTeaByKey(BigDecimal cmmdtyId) throws ZydException;

    /**
     * 根据商品编号查询商品
     * 
     * @param cmmdtyNum 商品编号
     * @return 商品
     * @throws ZydException
     */
    CommodityBean queryCommodityByCmmdtyNum(String cmmdtyNum) throws ZydException;

    /**
     * 根据综合条件查询紫砂壶
     * 
     * @param queryParam 综合条件，后面优化成查询对象vo
     * @param criteria 排序标准
     * @param pageSize 分页大小
     * @param page 查询页
     * @return 紫砂壶集合
     * @throws ZydException
     */
    List<TeapotBean> queryTeapotBeans(TeapotSearchVo queryParam, CommoditySortCriteria criteria, int pageSize, int page)
            throws ZydException;

    /**
     * 根据综合条件查询紫砂壶记录数
     * 
     * @param queryParam 综合条件，后面优化成查询对象vo
     * @return 紫砂壶集合
     * @throws ZydException
     */
    int queryCountOfTeapotBeans(TeapotSearchVo queryParam) throws ZydException;

    /**
     * 根据综合条件查询精品
     * 
     * @param queryParam 综合条件
     * @param criteria 排序标准
     * @param pageSize 分页大小
     * @param page 查询页
     * @return 精品集合
     * @throws ZydException
     */
    List<BoutiqueBean> queryBoutiqueBeans(BoutiqueSearchVo queryParam, CommoditySortCriteria criteria, int pageSize,
            int page) throws ZydException;

    /**
     * 根据综合条件查询茶叶
     * 
     * @param queryParam 综合条件，后面优化成查询对象vo
     * @param criteria 排序标准
     * @param pageSize 分页大小
     * @param page 查询页
     * @return 茶叶集合
     * @throws ZydException
     */
    List<TeaBean> queryTeaBeans(TeaSearchVo queryParam, CommoditySortCriteria criteria, int pageSize, int page)
            throws ZydException;

    /**
     * 根据商品id与图片类型查询商品图片，根据image_seq升序排序
     * 
     * @param cmmdtyId 商品id
     * @param commodityImageType 图片类型
     * @return 商品图片集合
     * @throws ZydException
     */
    List<CommodityImageBean> queryCommodityImageBeans(BigDecimal cmmdtyId, CommodityImageType commodityImageType)
            throws ZydException;

    /**
     * 根据商品id查询商品清单
     * 
     * @param cmmdtyId 商品id
     * @return 商品清单集合
     * @throws ZydException
     */
    List<ItemListBean> queryItemListBeans(BigDecimal cmmdtyId) throws ZydException;

    /**
     * 根据清单id查询清单
     * 
     * @param itemId 清单id
     * @return 商品清单
     * @throws ZydException
     */
    ItemListBean queryItemListByKey(BigDecimal itemId) throws ZydException;

    /**
     * 根据清单描述查询清单
     * 
     * @param cmmdtyId 商品id
     * @param itemDesc 清单描述
     * @return 商品清单
     * @throws ZydException
     */
    ItemListBean queryItemListByDesc(BigDecimal cmmdtyId, String itemDesc) throws ZydException;

    /**
     * 根据商品id查询商品属性，根据seq字段升序排序
     * 
     * @param cmmdtyId 商品id
     * @return 商品属性集合
     * @throws ZydException
     */
    List<CommodityPropertyBean> queryCommodityPropertyBeans(BigDecimal cmmdtyId) throws ZydException;

    /**
     * 根据商品属性id查询商品属性
     * 
     * @param propertyId 商品属性id
     * @return 商品属性
     * @throws ZydException
     */
    CommodityPropertyBean queryCommodityPropertyByKey(BigDecimal propertyId) throws ZydException;

    /**
     * 根据商品类别查询属性配置
     * 
     * @param category 商品类别
     * @return 属性配置集合
     * @throws ZydException
     */
    List<PropertyConfigBean> queryPropertyConfigBeansByCategory(Category category) throws ZydException;

    /**
     * 根据会员id查询商品咨询，根据event_ts降序排序
     * 
     * @param partyId 会员id
     * @param pageSize 分页大小
     * @param page 查询页
     * @return 商品咨询集合
     * @throws ZydException
     */
    List<CommodityEnquiringBean> queryCommodityEnquiringBeansByParty(BigDecimal partyId, int pageSize, int page)
            throws ZydException;

    /**
     * 根据商品id查询商品咨询，根据event_ts降序排序
     * 
     * @param cmmdtyId 商品id
     * @param pageSize 分页大小
     * @param page 查询页
     * @return 商品咨询集合
     * @throws ZydException
     */
    List<CommodityEnquiringBean> queryCommodityEnquiringBeansByCommodity(BigDecimal cmmdtyId, int pageSize, int page)
            throws ZydException;

    /**
     * 根据咨询id查询商品咨询
     * 
     * @param enquiringId 咨询id
     * @return 商品咨询
     * @throws ZydException
     */
    CommodityEnquiringBean queryCommodityEnquiringBeansByKey(BigDecimal enquiringId) throws ZydException;

    /**
     * 根据商品id查询赠品
     * 
     * @param cmmdtyId 商品id
     * @return 商品集合
     * @throws ZydException
     */
    List<CommodityBean> queryGiftsByCommodity(BigDecimal cmmdtyId) throws ZydException;

    /**
     * 根据商品id查询商品标签
     * 
     * @param cmmdtyId 商品id
     * @return 商品标签
     * @throws ZydException
     */
    LabelBean queryLabelBeanByCommodity(BigDecimal cmmdtyId) throws ZydException;

    /**
     * 根据样式和值查询商品标签
     * 
     * @param labelStyle 标签样式
     * @param labelVal 标签值
     * @return 商品标签
     * @throws ZydException
     */
    LabelBean queryLabelBeanByVal(LabelStyle labelStyle, String labelVal) throws ZydException;
    
    /**
     * 根据标签id查询商品标签
     * 
     * @param labelId 标签id
     * @return 商品标签
     * @throws ZydException
     */
    LabelBean queryLabelBeanByKey(BigDecimal labelId) throws ZydException;

    /**
     * 根据商品id查询推荐商品
     * 
     * @param cmmdtyId 商品id
     * @return 被推荐商合集合
     * @throws ZydException
     */
    List<CommodityBean> queryRecommendedCommodityBeansByCommodity(BigDecimal cmmdtyId) throws ZydException;

    // ******************************************************************************
    // 商品清单 - Start
    // ******************************************************************************

    /**
     * 根据商品id查询商品清单
     * 
     * @param cmmdtyId 商品id
     * @return 商品清单集合对象
     * @throws ZydException
     */
    List<ItemListBean> queryCommodityItemList(BigDecimal cmmdtyId) throws ZydException;

    // ******************************************************************************
    // 商品清单 - End
    // ******************************************************************************
}
