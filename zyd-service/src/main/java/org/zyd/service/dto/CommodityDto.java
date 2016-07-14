package org.zyd.service.dto;

import java.math.BigDecimal;
import java.util.List;

import org.zyd.common.constants.Category;

public abstract class CommodityDto implements java.io.Serializable{
	private static final long serialVersionUID = -5111577690747247264L;
	
	private BigDecimal cmmdtyId;
    private Category category;
    private String introducer;
    private String auditor;

    private List<CommodityImageDto> commodityImageDtos;
    private List<CommodityImageDto> detailImageDtos;
    private List<ItemListDto> itemListDtos;
    private List<CommodityPropertyDto> commodityPropertyDtos;
    private LabelDto labelDto;
    private List<CommodityDto> gifts;
    private List<CommodityDto> recommendeds;

    private Boolean effective;
    
    public BigDecimal getCmmdtyId() {
        return cmmdtyId;
    }

    public void setCmmdtyId(BigDecimal cmmdtyId) {
        this.cmmdtyId = cmmdtyId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getIntroducer() {
        return introducer;
    }

    public void setIntroducer(String introducer) {
        this.introducer = introducer;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public List<CommodityImageDto> getCommodityImageDtos() {
        return commodityImageDtos;
    }

    public void setCommodityImageDtos(List<CommodityImageDto> commodityImageDtos) {
        this.commodityImageDtos = commodityImageDtos;
    }

    public List<CommodityImageDto> getDetailImageDtos() {
        return detailImageDtos;
    }

    public void setDetailImageDtos(List<CommodityImageDto> detailImageDtos) {
        this.detailImageDtos = detailImageDtos;
    }

    public List<ItemListDto> getItemListDtos() {
        return itemListDtos;
    }

    public void setItemListDtos(List<ItemListDto> itemListDtos) {
        this.itemListDtos = itemListDtos;
    }

    public List<CommodityPropertyDto> getCommodityPropertyDtos() {
        return commodityPropertyDtos;
    }

    public void setCommodityPropertyDtos(List<CommodityPropertyDto> commodityPropertyDtos) {
        this.commodityPropertyDtos = commodityPropertyDtos;
    }

    public LabelDto getLabelDto() {
        return labelDto;
    }

    public void setLabelDto(LabelDto labelDto) {
        this.labelDto = labelDto;
    }

    public List<CommodityDto> getGifts() {
        return gifts;
    }

    public void setGifts(List<CommodityDto> gifts) {
        this.gifts = gifts;
    }

    public List<CommodityDto> getRecommendeds() {
        return recommendeds;
    }

    public void setRecommendeds(List<CommodityDto> recommendeds) {
        this.recommendeds = recommendeds;
    }

    public Boolean getEffective() {
        return effective;
    }

    public void setEffective(Boolean effective) {
        this.effective = effective;
    }
}
