package org.zyd.store.base.mapper;

import java.util.List;

import org.zyd.store.base.entity.BaseEntity;
import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * Mapper层分页方法
 * 
 * @author Gejiankui
 */
public interface PaginatingMapper<T extends BaseEntity, Q extends BaseTerm> {
    /**
     * 
     * 查询总记录数
     * 
     * @param Q param
     * @return
     * @throws
     */
    int countOfSummary(Q param);

    /**
     * 
     * 根据条件查询具体某一页的记录
     * 
     * @param Q param
     * @return
     * @throws
     */
    List<T> listOfSummary(Q param);
}
