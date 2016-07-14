package org.zyd.service.inf;

import java.math.BigDecimal;
import java.util.List;

import org.zyd.common.constants.EvaluationLevel;
import org.zyd.common.exception.ZydException;
import org.zyd.service.dto.AddedEvaluationDto;
import org.zyd.service.dto.CommodityEvaluationDto;
import org.zyd.service.dto.EvaluationImageDto;
import org.zyd.service.dto.EvaluationLabelDto;

public interface EvaluationInf {

	/**
	 * <pre>
	 * 根据商品id查询评论
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
	 * @return 商品评论集合
	 * @throws ZydException
	 */
	List<CommodityEvaluationDto> queryEvaluationsByCommodity(
			BigDecimal cmmdtyId, int pageSize, int page) throws ZydException;

	
	
	/**
	 * <pre>
	 * 根据商品id及评论级别查询评论
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
	 * @param evaluationLevel 评论级别
	 * @param pageSize 分页大小
	 * @param page 请求页
	 * @return 商品评论集合
	 * @throws ZydException
	 */
	List<CommodityEvaluationDto> queryEvaluationsByLevel(BigDecimal cmmdtyId,
			EvaluationLevel evaluationLevel, int pageSize, int page)
			throws ZydException;
	
	
    /**
     * <pre>
     * 根据商品id及评论级别查询评论总数
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @param evaluationLevel 评论级别
     * @return 商品评论集合
     * @throws ZydException
     */
    int queryCountOfEvaluationsByLevel(BigDecimal cmmdtyId, EvaluationLevel evaluationLevel) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 根据商品id查询有图评论
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
	 * @return 商品评论集合
	 * @throws ZydException
	 */
	List<CommodityEvaluationDto> queryImagedEvaluations(BigDecimal cmmdtyId,
			int pageSize, int page) throws ZydException;
	
    /**
     * <pre>
     * 根据商品id查询有图评论总数
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @return 有图商品评论总数
     * @throws ZydException
     */
    int queryCountOfImagedEvaluations(BigDecimal cmmdtyId) throws ZydException;
	
	
	/**
	 * <pre>
	 * 根据商品id查询带追评评论
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
	 * @return 商品评论集合
	 * @throws ZydException
	 */
	List<CommodityEvaluationDto> queryEvaluationsWithAddedEvaluations(
			BigDecimal cmmdtyId, int pageSize, int page) throws ZydException;
	
	
    /**
     * <pre>
     * 根据商品id查询带追评评论总数
     * 
     * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * </pre>
     * 
     * @param cmmdtyId 商品id
     * @return 商品评论集合总数
     * @throws ZydException
     */
    int queryCountOfEvaluationsWithAddedEvaluations(BigDecimal cmmdtyId) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 根据会员id查询评论
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
	 * @return 商品评论集合
	 * @throws ZydException
	 */
	List<CommodityEvaluationDto> queryEvaluationsByParty(
			BigDecimal partyId, int pageSize, int page) throws ZydException;
	

	
	/**
	 * <pre>
	 * 创建新的商品评价
	 * 
	 * 备注：
	 * 1. 根据orderId与cmmdtyId查询订单商品表，若评价状态为已评价（A4600020），提示EZYDP002("商品重复评论")。
	 * 2. 评价级别根据星级自动取值
	 *        星级为1时，级别为差评A3100030
	 *        星级为2-3时，级别为中评	A3100020
	 *        星级为4-5时，级别为好评	A3100010
	 * 3. 对于已存在标签，建立评价与标签的关系，同时将标签hit_times字段+1
	 * 4. 对于新增标签，创建新标签的同时，建立评价与标签的关系，同时将标签hit_times字段+1
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDE013 会员不存在
	 * EZYDE032 商品不存在
	 * EZYDP001 订单不存在
	 * EZYDP002 商品重复评论
	 * EZYDP003 评价星级取值范围1-5
	 * EZYDP004 评价内容不能为空
	 * EZYDP005 评价内容不能少于5个字符
	 * EZYDP006 评价内容最大为300个字符
	 * EZYDP007 评价标签id对应的标签不存在
	 * EZYDP008 新评价标签最大为10个字符
	 * EZYDP009 评价图片地址最大为200个字符
	 * </pre>
	 * 
	 * @param partyId 会员id
	 * @param orderId 订单id
	 * @param cmmdtyId 商品id
	 * @param numOfStars 评价星级
	 * @param evalContent 评价内容
	 * @param existLabelIds 已存在商品评价标签id集合（可选）
	 * @param newLabels 新增评价标签（可选）
	 * @param imageAddrs 评价图片地址集合（可选）
	 * @throws ZydException
	 */
	void createEvaluation(BigDecimal partyId, BigDecimal orderId,
			BigDecimal cmmdtyId, int numOfStars, String evalContent,
			List<BigDecimal> existLabelIds, List<String> newLabels,
			List<String> imageAddrs) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 屏蔽评论
	 * 
	 * 备注：
	 * 1. 屏蔽的评论，在评论列表页正常查询出来，仅在显示的时候屏蔽其内容
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDP010 评价不存在
	 * EZYDP011 评价已经被屏蔽
	 * </pre>
	 * 
	 * @param evalId 评价id
	 * @throws ZydException
	 */
	void forbidEvaluation(BigDecimal evalId) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 回复评价
	 * 
	 * 备注：
	 * 1. 追评类型为官方回复A3150020
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDP010 评价不存在
	 * EZYDP012 评价回复内容不能为空
	 * EZYDP013 评价回复内容不能少于5个字符
	 * EZYDP014 评价回复内容最大为300个字符
	 * </pre>
	 * 
	 * @param evalId 评价id
	 * @param addedEvalContent 回复内容
	 * @throws ZydException
	 */
	void acknowledgeEvaluation(BigDecimal evalId, String addedEvalContent) throws ZydException;
	
	
	//******************************************************************************
	// 评论图片 - Start
	//******************************************************************************
	
	/**
	 * <pre>
	 * 根据评论id查询评论图片
	 * 
	 * 备注：
	 * 1. 根据image_seq升序排序
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * 
	 * @param evalId 评论id
	 * @return 评论图片集合
	 * @throws ZydException
	 */
	List<EvaluationImageDto> queryImagesByEvaluation(BigDecimal evalId) throws ZydException;
	
	//******************************************************************************
	// 评论图片 - End
	//******************************************************************************
	
	
	
	//******************************************************************************
	// 评论追评 - Start
	//******************************************************************************
	
	/**
	 * <pre>
	 * 根据评论id查询评论追评
	 * 
	 * 备注：
	 * 1. 根据event_ts升序排序
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * 
	 * @param evalId 评论id
	 * @return 论评追评集合
	 * @throws ZydException
	 */
	List<AddedEvaluationDto> queryAddedEvaluations(BigDecimal evalId) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 追加评价
	 * 
	 * 备注：
	 * 1. 追评类型为客户追评	A3150010
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDP010 评价不存在
	 * EZYDP015 追评内容不能为空
	 * EZYDP016 追评内容不能少于5个字符
	 * EZYDP017 追评内容最大为300个字符
	 * </pre>
	 * 
	 * @param evalId 评价id
	 * @param addedEvalContent 追评内容
	 * @throws ZydException
	 */
	void createAddedEvaluation(BigDecimal evalId, String addedEvalContent) throws ZydException;
	
	//******************************************************************************
	// 评论追评 - End
	//******************************************************************************
	
	
	
	//******************************************************************************
	// 评论标签 - Start
	//******************************************************************************
	
	/**
	 * <pre>
	 * 根据商品id查询评论标签
	 * 
	 * 备注：
	 * 1. 根据hit_times降序排序
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * 
	 * @param cmmdtyId 商品id
	 * @return 评论标签集合
	 * @throws ZydException
	 */
	List<EvaluationLabelDto> queryEvaluationLabelsByCommodity(BigDecimal cmmdtyId) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 根据评论id查询评论标签
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * 
	 * @param evalId 评论id
	 * @return 评论标签集合
	 * @throws ZydException
	 */
	List<EvaluationLabelDto> queryEvaluationLabelsByEvaluation(BigDecimal evalId) throws ZydException;
	
	//******************************************************************************
	// 评论标签 - End
	//******************************************************************************
}
