package org.zyd.domain.bean;

import java.math.BigDecimal;
import java.util.List;

import org.zyd.common.constants.Category;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.CommodityOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface CommodityBean extends BaseOperation, RemoveOperation, CommodityOperation {

    void saveRecursively() throws ZydException;

    List<CommodityImageBean> getCommodityImageBeans();

    void setCommodityImageBeans(List<CommodityImageBean> commodityImageBeans);

    List<CommodityImageBean> getDetailImageBeans();

    void setDetailImageBeans(List<CommodityImageBean> detailImageBeans);

    List<ItemListBean> getItemListBeans();

    void setItemListBeans(List<ItemListBean> itemListBeans);

    List<CommodityPropertyBean> getCommodityPropertyBeans();

    void setCommodityPropertyBeans(List<CommodityPropertyBean> commodityPropertyBeans);

    LabelBean getLabelBean();

    void setLabelBean(LabelBean labelBean);

    List<CommodityBean> getGifts();

    void setGifts(List<CommodityBean> gifts);

    List<CommodityBean> getRecommendeds();

    void setRecommendeds(List<CommodityBean> recommendeds);

    BigDecimal getCmmdtyId();

    Category getCategory();

    String getIntroducer();

    String getAuditor();

    void setCmmdtyId(BigDecimal cmmdtyId);

    void setCategory(Category category);

    void setIntroducer(String introducer);

    void setAuditor(String auditor);

}
