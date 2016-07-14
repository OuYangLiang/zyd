package org.zyd.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import org.zyd.domain.bean.AddedEvaluationBean;
import org.zyd.domain.bean.CommodityEvaluationBean;
import org.zyd.domain.bean.EvaluationImageBean;
import org.zyd.domain.bean.EvaluationLabelBean;
import org.zyd.common.constants.EvaluationLevel;
import org.zyd.common.exception.ZydException;

public interface EvaluationRepos {

	/**
	 * 根据商品id查询商品评价，根据event_ts降序排序
	 * 
	 * @param cmmdtyId 商品id
	 * @param pageSize 分页大小
	 * @param page 请求页
	 * @return 商品评价集合
	 * @throws ZydException
	 */
	List<CommodityEvaluationBean> queryCommodityEvaluationBeansByCommodity(
			BigDecimal cmmdtyId, int pageSize, int page) throws ZydException;

	/**
	 * 根据商品id与评价级别查询商品评价，根据event_ts降序排序
	 * 
	 * @param cmmdtyId 商品id
	 * @param evaluationLevel 评价级别
	 * @param pageSize 分页大小
	 * @param page 请求页
	 * @return 商品评价集合
	 * @throws ZydException
	 */
	List<CommodityEvaluationBean> queryCommodityEvaluationBeansByLevel(
			BigDecimal cmmdtyId, EvaluationLevel evaluationLevel, int pageSize,
			int page) throws ZydException;

    /**
     * 根据商品id与评价级别查询商品评价总数
     * 
     * @param cmmdtyId 商品id
     * @param evaluationLevel 评价级别
     * @return 商品评价集合
     * @throws ZydException
     */
    int queryCountOfCommodityEvaluationBeansByLevel(BigDecimal cmmdtyId, EvaluationLevel evaluationLevel)
            throws ZydException;
	
	/**
	 * 根据商品id查询有图商品评价，根据event_ts降序排序
	 * 
	 * @param cmmdtyId 商品id
	 * @param pageSize 分页大小
	 * @param page 请求页
	 * @return 商品评价集合
	 * @throws ZydException
	 */
	List<CommodityEvaluationBean> queryImagedCommodityEvaluationBeansByCommodity(
			BigDecimal cmmdtyId, int pageSize, int page) throws ZydException;
	
    /**
     * 根据商品id查询有图商品评价总数
     * 
     * @param cmmdtyId 商品id
     * @return 有图商品评价集合总数
     * @throws ZydException
     */
    int queryCountOfImagedCommodityEvaluationBeansByCommodity(BigDecimal cmmdtyId) throws ZydException;
	
	/**
	 * 根据商品id查询有追评商品评价，根据event_ts降序排序
	 * 
	 * @param cmmdtyId 商品id
	 * @param pageSize 分页大小
	 * @param page 请求页
	 * @return 商品评价集合
	 * @throws ZydException
	 */
	List<CommodityEvaluationBean> queryCommodityEvaluationBeansWhichContainsAddedEvaluationsByCommodity(
			BigDecimal cmmdtyId, int pageSize, int page) throws ZydException;
	
    /**
     * 根据商品id查询有追评商品评价总数
     * 
     * @param cmmdtyId 商品id
     * @return 商品评价集合
     * @throws ZydException
     */
    int queryCountOfCommodityEvaluationBeansWhichContainsAddedEvaluationsByCommodity(BigDecimal cmmdtyId)
            throws ZydException;
	
	/**
	 * 根据会员id查询商品评价，根据event_ts降序排序
	 * 
	 * @param partyId 会员id
	 * @param pageSize 分页大小
	 * @param page 请求页
	 * @return 商品评价集合
	 * @throws ZydException
	 */
	List<CommodityEvaluationBean> queryCommodityEvaluationBeansByPartyId(
			BigDecimal partyId, int pageSize, int page) throws ZydException;
	
    /**
     * 根据评价id查询商品评价
     * 
     * @param evalId 评价id
     * @return 商品评价
     * @throws ZydException
     */
    CommodityEvaluationBean queryCommodityEvaluationBeanByKey(BigDecimal evalId) throws ZydException;
	
	/**
	 * 根据评价id查询评价图片，根据image_seq升序排序
	 * 
	 * @param evalId 评价id
	 * @return 评价图片集合
	 * @throws ZydException
	 */
	List<EvaluationImageBean> queryEvaluationImageBeansByEvaluation(BigDecimal evalId) throws ZydException;
	
	/**
	 * 根据评价id查询追评，根据event_ts升序排序
	 * 
	 * @param evalId 评价id
	 * @return 追评集合
	 * @throws ZydException
	 */
	List<AddedEvaluationBean> queryAddedEvaluationBeansByEvaluation(BigDecimal evalId) throws ZydException;
	
	/**
	 * 查询商品id查询评价标签，根据hit_times降序排序
	 * 
	 * @param cmmdtyId 商品id
	 * @return 评价标签集合
	 * @throws ZydException
	 */
	List<EvaluationLabelBean> queryEvaluationLabelBeansByCommodity(BigDecimal cmmdtyId) throws ZydException;
	
	/**
	 * 查询标签id查询评价标签
	 * 
	 * @param labelId 标签id
	 * @return 评价标签
	 * @throws ZydException
	 */
	EvaluationLabelBean queryEvaluationLabelBeanByKey(BigDecimal labelId) throws ZydException;
	
	/**
	 * 查询评价id查询评价标签
	 * 
	 * @param evalId 评价id
	 * @return 评价标签集合
	 * @throws ZydException
	 */
	List<EvaluationLabelBean> queryEvaluationLabelsByEvaluation(BigDecimal evalId) throws ZydException;
}
