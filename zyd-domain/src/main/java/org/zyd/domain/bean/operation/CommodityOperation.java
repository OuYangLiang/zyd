package org.zyd.domain.bean.operation;

import java.math.BigDecimal;

import org.zyd.common.constants.CommodityImageType;
import org.zyd.common.constants.LabelStyle;
import org.zyd.common.exception.ZydException;

public interface CommodityOperation {

    /**
     * 商品审核通过
     * 
     * @throws ZydException
     */
    void approve(String auditor) throws ZydException;

    /**
     * 设置商品赠品关系
     * 
     * @param cmmdtyId 赠品商品id
     * @throws ZydException
     */
    void addGift(BigDecimal cmmdtyId) throws ZydException;

    /**
     * 是否存在赠品关系
     * 
     * @param giftCmmdtyId 赠品商品id
     * @return
     * @throws ZydException
     */
    boolean isGiftContaining(BigDecimal giftCmmdtyId) throws ZydException;

    /**
     * 删除赠品关系
     * 
     * @param cmmdtyId 赠品商品id
     * @throws ZydException
     */
    void removeGift(BigDecimal cmmdtyId) throws ZydException;

    /**
     * 设置推荐商品关系
     * 
     * @param cmmdtyId 被推荐商品id
     * @throws ZydException
     */
    void addRecommended(BigDecimal cmmdtyId) throws ZydException;

    /**
     * 是否存在推荐关系
     * 
     * @param recommendedCmmdtyId 被推荐商品id
     * @return
     * @throws ZydException
     */
    boolean isRecommendRel(BigDecimal recommendedCmmdtyId) throws ZydException;

    /**
     * 删除推荐关系
     * 
     * @param cmmdtyId 被推荐商品id
     * @throws ZydException
     */
    void removeRecommended(BigDecimal cmmdtyId) throws ZydException;

    /**
     * 增加商品属性
     * 
     * @param propName 属性名称
     * @param propVal 属性值
     * @param seq 位置：seq为－1时，排列到最后位置；seq为0时，排列至首位，其它元素依次后移；seq为队列中间值时，位置大于等于seq的元素依次后移。
     * @throws ZydException
     */
    void addProperty(String propName, String propVal, int seq) throws ZydException;

    /**
     * 更新商品属性值
     * 
     * @param propertyId 属性id
     * @param propVal 属性新值
     * @throws ZydException
     */
    void updateProperty(BigDecimal propertyId, String propVal) throws ZydException;

    /**
     * 更新商品属性排列位置
     * 
     * @param propertyId 属性id
     * @param seq 位置：seq为－1时，排列到最后位置；seq为0时，排列至首位，其它元素依次后移；seq为队列中间值时，位置大于等于seq的元素依次后移。
     * @throws ZydException
     */
    void updatePropertyPosition(BigDecimal propertyId, int seq) throws ZydException;

    /**
     * 删除商品属性
     * 
     * @param propertyId 属性id
     * @throws ZydException
     */
    void removeProperty(BigDecimal propertyId) throws ZydException;

    /**
     * 删除商品所有属性
     * 
     * @throws ZydException
     */
    void cleanCommodityProperties() throws ZydException;

    /**
     * 增加商品图片
     * 
     * @param commodityImageType 图片类型
     * @param imageAddrs 图片地址
     * @param seq 位置：seq为－1时，排列到最后位置；seq为0时，排列至首位，其它元素依次后移；seq为队列中间值时，位置大于等于seq的元素依次后移。
     * @throws ZydException
     */
    void addImage(CommodityImageType commodityImageType, String imageAddrs, int seq) throws ZydException;

    /**
     * 更新商品图片排列位置
     * 
     * @param imageId 图片id
     * @param seq 位置：seq为－1时，排列到最后位置；seq为0时，排列至首位，其它元素依次后移；seq为队列中间值时，位置大于等于seq的元素依次后移。
     * @throws ZydException
     */
    void updateImagePosition(BigDecimal imageId, int seq) throws ZydException;

    /**
     * 删除商品图片
     * 
     * @param imageId 图片id
     * @throws ZydException
     */
    void removeImage(BigDecimal imageId) throws ZydException;

    /**
     * 根据类型删除商品图片
     * 
     * @param commodityImageType 图片类型
     */
    void cleanImageByType(CommodityImageType commodityImageType) throws ZydException;

    /**
     * 根据样式和值设置商品标签
     * 
     * @param labelStyle 标签样式
     * @param labelVal 标签值
     * @throws ZydException
     */
    void setLabel(LabelStyle labelStyle, String labelVal) throws ZydException;

    /**
     * 根据标签id设置商品标签
     * 
     * @param labelId 标签id
     * @throws ZydException
     */
    void setLabel(BigDecimal labelId) throws ZydException;

    /**
     * 根据商品id移除商品标签
     * 
     * @throws ZydException
     */
    void removeLabel() throws ZydException;

    /**
     * 根据标签id和商品id移除商品标签
     * 
     * @param labelId 标签id
     * @throws ZydException
     */
    void removeCmmdtyLabel(BigDecimal labelId) throws ZydException;

    // ******************************************************************************
    // 商品清单 - Start
    // ******************************************************************************

    /**
     * 更新商品包装清单数量
     * 
     * @param itemId 包装清单id
     * @param qty 数量
     * @throws ZydException
     */
    void updateCommodityItemList(BigDecimal itemId, int qty) throws ZydException;

    /**
     * 增加包装清单
     * 
     * @param itemDesc 包装清单描述
     * @param qty 数量
     * @throws ZydException
     */
    void addCommodityItemList(String itemDesc, int qty) throws ZydException;

    /**
     * 删除商品清单
     * 
     * @param itemId 包装清单id
     * @throws ZydException
     */
    void removeCommodityItemList(BigDecimal itemId) throws ZydException;

    // ******************************************************************************
    // 商品清单 - End
    // ******************************************************************************
}
