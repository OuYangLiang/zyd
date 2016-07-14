package org.zyd.service.inf;

import java.math.BigDecimal;
import java.util.List;

import org.zyd.common.constants.CommodityImageType;
import org.zyd.common.constants.CommoditySortCriteria;
import org.zyd.common.exception.ZydException;
import org.zyd.common.vo.BoutiqueSearchVo;
import org.zyd.common.vo.TeaSearchVo;
import org.zyd.common.vo.TeapotSearchVo;
import org.zyd.service.dto.BoutiqueDto;
import org.zyd.service.dto.CommodityDto;
import org.zyd.service.dto.CommodityEnquiringDto;
import org.zyd.service.dto.CommodityImageDto;
import org.zyd.service.dto.CommodityPropertyDto;
import org.zyd.service.dto.ItemListDto;
import org.zyd.service.dto.LabelDto;
import org.zyd.service.dto.TeaDto;
import org.zyd.service.dto.TeapotDto;

public interface CommodityInf {

    /**
     * <pre>
     * 创建商品
     * 
     * 备注：
     * 
     * 1. 创建商品时，不涉及标签、赠品与推荐商品的处理。
     * 2. 根据category判断创建壶、精品还是茶
     * 3. 创建商品时，子表信息写入待审核表，即pending_teapot、pending_tea或pending_boutique表。
     * 4. 商品销量与评论数量在创建时固定为0
     * 5. 紫砂壶销售方式固定为A2600010("普通")
     * 6. 强制把auditor字段置为null
     * 7. 商品图片的seq字段，不从传参中取值，根据传入的图片在该方法内重新为seq赋值（注意根据类型分组）
     * 8. 商品属性在创建时为可选，如果有传值，则需要进行验证。
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDH001 商品类型不能为空
     * EZYDH002 商品名称不能为空
     * EZYDH003 商品名称最大为25个字符
     * EZYDH004 商品描述最大200个字符
     * EZYDH005 商品库存量不能小于0
     * EZYDH006 商品指导价不能为空
     * EZYDH007 商品指导价必须大于0
     * EZYDH008 商品单价不能为空
     * EZYDH009 商品单价必须大于0
     * EZYDH010 商品上架时间不能为空
     * EZYDH011 商品默认图片地址不能为空
     * EZYDH012 商品默认图片地址最大为200个字符
     * EZYDH013 紫砂壶器型不能为空
     * EZYDH014 紫砂壶壶型不能为空
     * EZYDH015 紫砂壶泥料不能为空
     * EZYDH016 紫砂壶容量不能为空
     * EZYDH017 紫砂壶容量必须大于0
     * EZYDH018 紫砂壶级别不能为空
     * EZYDH019 紫砂壶价格区间不能为空
     * EZYDH020 茶叶类型不能为空
     * EZYDH021 茶叶产地不能为空
     * EZYDH022 茶叶等级不能为空
     * EZYDH023 茶叶包装方式不能为空
     * EZYDH024 茶叶价格区间不能为空
     * EZYDH025 商品图片类型不能为空
     * EZYDH026 商品图片地址不能为空
     * EZYDH027 商品图片地址最大为200个字符
     * EZYDH029 图片列表中没有商品图
     * EZYDH030 图片列表中没有商品图（大）
     * EZYDH031 图片列表中没有商品详情图
     * EZYDH032 包装清单不能为空
     * EZYDH033 包装清单描述不能为空
     * EZYDH034 包装清单描述最大为50个字符
     * EZYDH035 包装清单数量不能为空
     * EZYDH045 包装清单数量不能小于0
     * EZYDH036 包装清单数量不能超过1000
     * EZYDH037 商品库存量不能超过10000
     * EZYDH038 商品属性名称不能为空
     * EZYDH039 商品属性名称最大为15个字符
     * EZYDH040 商品属性值不能为空
     * EZYDH041 商品属性值最大为30个字符
     * 
     * </pre>
     * 
     * @param commodityDto 商品对象
     * @throws ZydException
     */
    void createCommodity(CommodityDto commodityDto) throws ZydException;

    /**
     * <pre>
     * 更新商品信息
     * 
     * 备注：
     * 1. 该方法仅更新商品子表：boutique, teapot, tea, pending_boutique, pending_teapot, pending_tea
     * 2. 通过commodity表auditor及category字段判断具体更新哪一个表
     * 3. 该方法不涉及category、auditor字段的更新
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDE032 商品不存在
     * EZYDH003 商品名称最大为25个字符
     * EZYDH004 商品描述最大200个字符
     * EZYDH005 商品库存量不能小于0
     * EZYDH007 商品指导价必须大于0
     * EZYDH009 商品单价必须大于0
     * EZYDH012 商品默认图片地址最大为200个字符
     * EZYDH017 紫砂壶容量必须大于0
     * EZYDH037 商品库存量不能超过10000
     * </pre>
     * 
     * @param commodityDto 商品对象
     * @throws ZydException
     */
    void updateCommodity(CommodityDto commodityDto) throws ZydException;

    /**
     * <pre>
     * 审核商品
     * 
     * 备注：
     * 1. 商品是否审核通过Commodity表中auditor字段是否为空判断。
     * 2. 商品审核时，同步判断商品上架时间：
     *        若已经到了上架时间，则需要把数据从待审核表移到普通表。
     *        若未到上架时间，则不移。每天会有Job专门处理。
     * 3. 商品上架时间字段：shelves_time，精确到天。
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDE032 商品不存在
     * EZYDH042 商品已经审核通过
     * </pre>
     * 
     * @param auditor 审核者工号
     * @param cmmdtyId 商品id
     * @throws ZydException
     */
    void approveCommodity(String auditor, BigDecimal cmmdtyId) throws ZydException;

    /**
     * <pre>
     * 根据商品编号查询商品
     * 
     * 备注：
     * 1. 仅已审核商品可以被查到。
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDH043 非法商品编号
     * </pre>
     * 
     * @param cmmdtyNum 商品编号
     * @return 商品对象
     * @throws ZydException
     */
    CommodityDto queryCommodityByCmmdtyNum(String cmmdtyNum) throws ZydException;

    /**
     * <pre>
     * 根据商品id查询商品
     * 
     * 备注：
     * 1. 先查询Commodity表
     *        若已经审核通过，则继续查商品普通子表
     *        若还未审核，则查询商品待审核子表
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @return 紫砂壶对象
     * @throws ZydException
     */
    CommodityDto queryCommodityByKey(BigDecimal cmmdtyId) throws ZydException;

    /**
     * <pre>
     * 根据商品id查询紫砂壶
     * 
     * 备注：
     * 1. 仅已审核商品可以被查到。
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @return 紫砂壶对象
     * @throws ZydException
     */
    TeapotDto queryTeapotByKey(BigDecimal cmmdtyId) throws ZydException;

    /**
     * <pre>
     * 根据商品id查询茶叶
     * 
     * 备注：
     * 1. 仅已审核商品可以被查到。
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @return 茶叶对象
     * @throws ZydException
     */
    TeaDto queryTeaByKey(BigDecimal cmmdtyId) throws ZydException;

    /**
     * <pre>
     * 根据商品id查询精品
     * 
     * 备注：
     * 1. 仅已审核商品可以被查到。
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @return 精品对象
     * @throws ZydException
     */
    BoutiqueDto queryBoutiqueByKey(BigDecimal cmmdtyId) throws ZydException;

    /**
     * <pre>
     * 根据综合条件查询紫砂壶
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * </pre>
     * 
     * @param queryParam 综合条件
     * @param criteria 排序标准
     * @param pageSize 分页大小
     * @param page 请求页
     * @return 紫砂壶
     * @throws ZydException
     */
    List<TeapotDto> queryTeapots(TeapotSearchVo queryParam, CommoditySortCriteria criteria, int pageSize, int page)
            throws ZydException;
    
    /**
     * <pre>
     * 根据综合条件查询紫砂壶总记录数
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * </pre>
     * 
     * @param queryParam 综合条件
     * @return 紫砂壶
     * @throws ZydException
     */
    int queryCountOfTeapots(TeapotSearchVo queryParam)
            throws ZydException;

    /**
     * <pre>
     * 根据综合条件查询精品
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * </pre>
     * 
     * @param queryParam 综合条件
     * @param criteria 排序标准
     * @param pageSize 分页大小
     * @param page 请求页
     * @return 精品
     * @throws ZydException
     */
    List<BoutiqueDto> queryBoutiques(BoutiqueSearchVo queryParam, CommoditySortCriteria criteria, int pageSize, int page)
            throws ZydException;

    /**
     * <pre>
     * 根据综合条件查询茶叶
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * </pre>
     * 
     * @param queryParam 综合条件
     * @param criteria 排序标准
     * @param pageSize 分页大小
     * @param page 请求页
     * @return 茶叶
     * @throws ZydException
     */
    List<TeaDto> queryTeas(TeaSearchVo queryParam, CommoditySortCriteria criteria, int pageSize, int page)
            throws ZydException;

    // ******************************************************************************
    // 商品属性 - Start
    // ******************************************************************************

    /**
     * <pre>
     * 根据商品id查询商品属性集合
     * 
     * 备注：
     * 1. 根据seq字段升序排序
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @return 属性集合
     * @throws ZydException
     */
    List<CommodityPropertyDto> queryCommodityProperties(BigDecimal cmmdtyId) throws ZydException;

    /**
     * <pre>
     * 更新商品属性值
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDE032 商品不存在
     * EZYDH044 商品属性不存在
     * EZYDH040 商品属性值不能为空
     * EZYDH041 商品属性值最大为30个字符
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @param propertyId 属性id
     * @param propVal 属性值
     * @throws ZydException
     */
    void updateCommodityProperty(BigDecimal cmmdtyId, BigDecimal propertyId, String propVal) throws ZydException;

    /**
     * <pre>
     * 更新商品属性值
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDE032 商品不存在
     * EZYDH038 商品属性名称不能为空
     * EZYDH039 商品属性名称最大为15个字符
     * EZYDH044 商品属性不存在
     * EZYDH040 商品属性值不能为空
     * EZYDH041 商品属性值最大为30个字符
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @param propName 属性名称
     * @param propVal 属性值
     * @throws ZydException
     */
    // void updateCommodityProperty(BigDecimal cmmdtyId, String propName, String propVal) throws ZydException;

    /**
     * <pre>
     * 重置商品属性
     * 
     * 备注：
     * 1. 该方法先根据商品id删除原有所有属性，再重新创建新的属性集合
     * 2. 方法传参中，只取属性名称与属性值，强制对seq根据propertyies顺序重新赋值
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDE032 商品不存在
     * EZYDH038 商品属性名称不能为空
     * EZYDH039 商品属性名称最大为15个字符
     * EZYDH040 商品属性值不能为空
     * EZYDH041 商品属性值最大为30个字符
     * 
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @param properties 商品性性集合
     * @throws ZydException
     */
    void resetCommodityProperties(BigDecimal cmmdtyId, List<CommodityPropertyDto> properties) throws ZydException;

    /**
     * <pre>
     * 删除商品所有属性
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDE032 商品不存在
     * </pre>
     * 
     * @param cmmdtyId
     * @throws ZydException
     */
    void cleanCommodityProperties(BigDecimal cmmdtyId) throws ZydException;

    // ******************************************************************************
    // 商品属性 - End
    // ******************************************************************************

    // ******************************************************************************
    // 商品清单 - Start
    // ******************************************************************************

    /**
     * <pre>
     * 根据商品id查询商品清单
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @return 商品清单集合对象
     * @throws ZydException
     */
    List<ItemListDto> queryCommodityItemList(BigDecimal cmmdtyId) throws ZydException;

    /**
     * <pre>
     * 更新商品包装清单数量
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDE032 商品不存在
     * EZYDH033 包装清单描述不能为空
     * EZYDH034 包装清单描述最大为50个字符
     * EZYDH046 包装清单不存在
     * EZYDH045 包装清单数量不能小于0
     * EZYDH036 包装清单数量不能超过1000
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @param itemDesc 包装清单描述
     * @param qty 数量
     * @throws ZydException
     */
    // void updateCommodityItemList(BigDecimal cmmdtyId, String itemDesc, int qty) throws ZydException;

    /**
     * <pre>
     * 更新商品包装清单数量
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDE032 商品不存在
     * EZYDH046 包装清单不存在
     * EZYDH045 包装清单数量不能小于0
     * EZYDH036 包装清单数量不能超过1000
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @param itemId 包装清单id
     * @param qty 数量
     * @throws ZydException
     */
    void updateCommodityItemList(BigDecimal cmmdtyId, BigDecimal itemId, int qty) throws ZydException;

    /**
     * <pre>
     * 增加包装清单
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDE032 商品不存在
     * EZYDH033 包装清单描述不能为空
     * EZYDH034 包装清单描述最大为50个字符
     * EZYDH047 包装清单已经存在
     * EZYDH045 包装清单数量不能小于0
     * EZYDH036 包装清单数量不能超过1000
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @param itemDesc 包装清单描述
     * @param qty 数量
     * @throws ZydException
     */
    void addCommodityItemList(BigDecimal cmmdtyId, String itemDesc, int qty) throws ZydException;

    /**
     * <pre>
     * 删除商品清单
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDE032 商品不存在
     * EZYDH033 包装清单描述不能为空
     * EZYDH034 包装清单描述最大为50个字符
     * EZYDH046 包装清单不存在
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @param itemDesc 包装清单描述
     * @throws ZydException
     */
    // void removeCommodityItemList(BigDecimal cmmdtyId, String itemDesc) throws ZydException;

    /**
     * <pre>
     * 删除商品清单
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDE032 商品不存在
     * EZYDH046 包装清单不存在
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @param itemId 包装清单id
     * @throws ZydException
     */
    void removeCommodityItemList(BigDecimal cmmdtyId, BigDecimal itemId) throws ZydException;

    // ******************************************************************************
    // 商品清单 - End
    // ******************************************************************************

    // ******************************************************************************
    // 商品图片 - Start
    // ******************************************************************************

    /**
     * <pre>
     * 根据商品id与图片类型查询商品图片
     * 
     * 备注：
     * 根据image_seq字段升序排序
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @param type 图片类型
     * @return 商品图片集合
     * @throws ZydException
     */
    List<CommodityImageDto> queryCommodityImages(BigDecimal cmmdtyId, CommodityImageType type) throws ZydException;

    /**
     * <pre>
     * 根据图片类型重置商品图片
     * 
     * 备注：
     * 1. 该方法先根据商品id删除原有全部同类型图片，再重新创建新的图片集合
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDE032 商品不存在
     * EZYDH025 商品图片类型不能为空
     * EZYDH026 商品图片地址不能为空
     * EZYDH027 商品图片地址最大为200个字符
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @param type 商品图片类型
     * @param imagesAddrs 商品图片地址集合
     * @throws ZydException
     */
    void resetCommodityImages(BigDecimal cmmdtyId, CommodityImageType type, List<String> imagesAddrs)
            throws ZydException;

    // ******************************************************************************
    // 商品图片 - End
    // ******************************************************************************

    // ******************************************************************************
    // 商品收藏 - Start
    // ******************************************************************************

    /**
     * <pre>
     * 查询会员收藏商品
     * 
     * 备注：
     * 1. 根据collected_time降序排序
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * </pre>
     * 
     * @param partyId 会员id
     * @param pageSize 分页大小
     * @param page 请求页
     * @return 商品集合
     * @throws ZydException
     */
    List<CommodityDto> queryCollectedCommoditiesByParty(BigDecimal partyId, int pageSize, int page) throws ZydException;

    // ******************************************************************************
    // 商品收藏 - End
    // ******************************************************************************

    // ******************************************************************************
    // 商品资询 - Start
    // ******************************************************************************

    /**
     * <pre>
     * 根据商品id查询商品资询
     * 
     * 备注：
     * 1. 根据event_ts降序排序
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @param pageSize 分页大小
     * @param page 请求页
     * @return 商品资询集合
     * @throws ZydException
     */
    List<CommodityEnquiringDto> queryCommodityEnquiringsByCommodity(BigDecimal cmmdtyId, int pageSize, int page)
            throws ZydException;

    /**
     * <pre>
     * 根据会员id查询商品资询
     * 
     * 备注：
     * 1. 根据event_ts降序排序
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * </pre>
     * 
     * @param partyId 会员id
     * @param pageSize 分页大小
     * @param page 请求页
     * @return 商品资询集合
     * @throws ZydException
     */
    List<CommodityEnquiringDto> queryCommodityEnquiringsByParty(BigDecimal partyId, int pageSize, int page)
            throws ZydException;

    /**
     * <pre>
     * 回复商品资询
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDH050 资询不存在
     * EZYDH051 资询回复人不能为空
     * EZYDH052 资询回复人最大为10个字符
     * EZYDH053 资询回复内容不能为空
     * EZYDH054 资询回复内容最大为300个字符
     * </pre>
     * 
     * @param enquiringId 商品资询id
     * @param answerer 回复人
     * @param answer 回复内容
     * @throws ZydException
     */
    void answerEnquiring(BigDecimal enquiringId, String answerer, String answer) throws ZydException;

    // ******************************************************************************
    // 商品资询 - End
    // ******************************************************************************

    // ******************************************************************************
    // 商品标签 - Start
    // ******************************************************************************

    /**
     * <pre>
     * 查询商品标签
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @return 商品标签
     * @throws ZydException
     */
    LabelDto queryLabelByCommodity(BigDecimal cmmdtyId) throws ZydException;

    /**
     * <pre>
     * 移除商品标签
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDE032 商品不存在
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @throws ZydException
     */
    void removeLabelFromCommodity(BigDecimal cmmdtyId) throws ZydException;

    /**
     * <pre>
     * 为商品设置标签
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDE032 商品不存在
     * EZYDH055 标签不存在
     * EZYDH056 商品已经设置了其它标签
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @param labelId 商品标签id
     * @throws ZydException
     */
    void setLabel(BigDecimal cmmdtyId, BigDecimal labelId) throws ZydException;

    /**
     * <pre>
     * 为商品设置标签
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDE032 商品不存在
     * EZYDH055 标签不存在
     * EZYDH056 商品已经设置了其它标签
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @param labelStyle 商品标签样式
     * @param labelVal 商品标签内容
     * @throws ZydException
     * 
     *             void setLabel(BigDecimal cmmdtyId, LabelStyle labelStyle, String labelVal) throws ZydException;
     */

    // ******************************************************************************
    // 商品标签 - End
    // ******************************************************************************

    // ******************************************************************************
    // 商品推荐 - Start
    // ******************************************************************************

    /**
     * <pre>
     * 增加推荐商品
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDE032 商品不存在
     * EZYDH063 被推荐商品不存在
     * EZYDH057 商品推荐关系已经存在
     * EZYDH059 商品推荐超出上限，最多推荐5个商品
     * </pre>
     * 
     * @param srcCmmdtyId 原商品id
     * @param recommendedCmmdtyId 被推荐商品id
     * @throws ZydException
     */
    void addRecommended(BigDecimal srcCmmdtyId, BigDecimal recommendedCmmdtyId) throws ZydException;

    /**
     * <pre>
     * 删除商品推荐关系
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDE032 商品不存在
     * EZYDH063 被推荐商品不存在
     * EZYDH058 商品推荐关系不存在
     * </pre>
     * 
     * @param srcCmmdtyId 原商品id
     * @param recommendedCmmdtyId 被推荐商品id
     * @throws ZydException
     */
    void removeRecommended(BigDecimal srcCmmdtyId, BigDecimal recommendedCmmdtyId) throws ZydException;

    /**
     * <pre>
     * 根据商品id查询商品推荐
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @return 商品集合对象
     * @throws ZydException
     */
    List<CommodityDto> queryRecommended(BigDecimal cmmdtyId) throws ZydException;

    // ******************************************************************************
    // 商品推荐 - End
    // ******************************************************************************

    // ******************************************************************************
    // 赠品 - Begin
    // ******************************************************************************

    /**
     * <pre>
     * 增加商品赠品
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDE032 商品不存在
     * EZYDH064 赠品商品不存在
     * EZYDH060 赠品关系已经存在
     * EZYDH062 商品赠品超出上限，最多5个赠品
     * </pre>
     * 
     * @param srcCmmdtyId 商品id
     * @param giftCmmdtyId 赠品id
     * @throws ZydException
     */
    void addGift(BigDecimal srcCmmdtyId, BigDecimal giftCmmdtyId) throws ZydException;

    /**
     * <pre>
     * 删除赠品关系
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDE032 商品不存在
     * EZYDH064 赠品商品不存在
     * EZYDH061 赠品关系不存在
     * </pre>
     * 
     * @param srcCmmdtyId 商品id
     * @param giftCmmdtyId 赠品id
     * @throws ZydException
     */
    void removeGift(BigDecimal srcCmmdtyId, BigDecimal giftCmmdtyId) throws ZydException;

    /**
     * <pre>
     * 根据商品id查询赠品
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @return 商品集合对象
     * @throws ZydException
     */
    List<CommodityDto> queryGift(BigDecimal cmmdtyId) throws ZydException;

    // ******************************************************************************
    // 赠品 - End
    // ******************************************************************************
}
