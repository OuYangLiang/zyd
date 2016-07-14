package org.zyd.service.inf.impl;

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
import org.zyd.common.constants.ErrorCode;
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
import org.zyd.domain.bean.TeaBean;
import org.zyd.domain.bean.TeapotBean;
import org.zyd.domain.factory.CommodityFactory;
import org.zyd.domain.repository.CommodityRepos;
import org.zyd.service.convertor.CommodityConvertor;
import org.zyd.service.dto.BoutiqueDto;
import org.zyd.service.dto.CommodityDto;
import org.zyd.service.dto.CommodityEnquiringDto;
import org.zyd.service.dto.CommodityImageDto;
import org.zyd.service.dto.CommodityPropertyDto;
import org.zyd.service.dto.ItemListDto;
import org.zyd.service.dto.LabelDto;
import org.zyd.service.dto.TeaDto;
import org.zyd.service.dto.TeapotDto;
import org.zyd.service.inf.CommodityInf;

public class CommodityInfImpl implements CommodityInf {

    @Autowired
    private CommodityFactory commodityFactory;
    @Autowired
    private CommodityRepos commodityRepos;
    @Autowired
    private CommodityConvertor commodityConvertor;

    @Override
    public void createCommodity(CommodityDto commodityDto) throws ZydException {
        if (null == commodityDto) {
            throw new IllegalArgumentException();
        }
        this.validateCommodity(commodityDto);
        // 壶
        // TODO 商品编号
        if (commodityDto.getCategory().equals(Category.A2100010)) {
            TeapotDto dto = (TeapotDto) commodityDto;
            if (StringUtils.isEmpty(dto.getCmmdtyName())) {
                throw new ZydException(ErrorCode.EZYDH002);
            }
            if (dto.getCmmdtyName().length() > 25) {
                throw new ZydException(ErrorCode.EZYDH003);
            }
            if (!StringUtils.isEmpty(dto.getCmmdtyDesc()) && dto.getCmmdtyDesc().length() > 255) {
                throw new ZydException(ErrorCode.EZYDH004);
            }
            if (dto.getNumStored() < 0) {
                throw new ZydException(ErrorCode.EZYDH005);
            }
            if (null == dto.getProposedPrice()) {
                throw new ZydException(ErrorCode.EZYDH006);
            }
            if (dto.getProposedPrice().compareTo(BigDecimal.ZERO) != 1) {
                throw new ZydException(ErrorCode.EZYDH007);
            }
            if (null == dto.getCurrentPrice()) {
                throw new ZydException(ErrorCode.EZYDH008);
            }
            if (dto.getCurrentPrice().compareTo(BigDecimal.ZERO) != 1) {
                throw new ZydException(ErrorCode.EZYDH009);
            }
            if (null == dto.getShelvesTime()) {
                throw new ZydException(ErrorCode.EZYDH010);
            }
            if (StringUtils.isEmpty(dto.getDefaultImageAddrs())) {
                throw new ZydException(ErrorCode.EZYDH011);
            }
            if (dto.getDefaultImageAddrs().length() > 200) {
                throw new ZydException(ErrorCode.EZYDH012);
            }
            if (null == dto.getType()) {
                throw new ZydException(ErrorCode.EZYDH013);
            }
            if (null == dto.getShape()) {
                throw new ZydException(ErrorCode.EZYDH014);
            }
            if (null == dto.getMaterial()) {
                throw new ZydException(ErrorCode.EZYDH015);
            }
            if (null == dto.getSize()) {
                throw new ZydException(ErrorCode.EZYDH016);
            }
            if (dto.getSize() <= 0) {
                throw new ZydException(ErrorCode.EZYDH017);
            }
            if (null == dto.getLevel()) {
                throw new ZydException(ErrorCode.EZYDH018);
            }
            if (null == dto.getPriceRegion()) {
                throw new ZydException(ErrorCode.EZYDH019);
            }
            if (dto.getNumStored() > 1000) {
                throw new ZydException(ErrorCode.EZYDH037);
            }
            TeapotBean bean = commodityConvertor.convertTeapotWithAll(commodityDto);
            bean.saveRecursively();
        } else if (commodityDto.getCategory().equals(Category.A2100050)) { // 茶叶
            TeaDto dto = (TeaDto) commodityDto;
            if (StringUtils.isEmpty(dto.getCmmdtyName())) {
                throw new ZydException(ErrorCode.EZYDH002);
            }
            if (dto.getCmmdtyName().length() > 25) {
                throw new ZydException(ErrorCode.EZYDH003);
            }
            if (!StringUtils.isEmpty(dto.getCmmdtyDesc()) && dto.getCmmdtyDesc().length() > 255) {
                throw new ZydException(ErrorCode.EZYDH004);
            }
            if (dto.getNumStored() < 0) {
                throw new ZydException(ErrorCode.EZYDH005);
            }
            if (null == dto.getProposedPrice()) {
                throw new ZydException(ErrorCode.EZYDH006);
            }
            if (dto.getProposedPrice().compareTo(BigDecimal.ZERO) != 1) {
                throw new ZydException(ErrorCode.EZYDH007);
            }
            if (null == dto.getCurrentPrice()) {
                throw new ZydException(ErrorCode.EZYDH008);
            }
            if (dto.getCurrentPrice().compareTo(BigDecimal.ZERO) != 1) {
                throw new ZydException(ErrorCode.EZYDH009);
            }
            if (null == dto.getShelvesTime()) {
                throw new ZydException(ErrorCode.EZYDH010);
            }
            if (StringUtils.isEmpty(dto.getDefaultImageAddrs())) {
                throw new ZydException(ErrorCode.EZYDH011);
            }
            if (dto.getDefaultImageAddrs().length() > 200) {
                throw new ZydException(ErrorCode.EZYDH012);
            }
            if (null == dto.getTeaType()) {
                throw new ZydException(ErrorCode.EZYDH020);
            }
            if (StringUtils.isEmpty(dto.getPlaceOfOrigin())) {
                throw new ZydException(ErrorCode.EZYDH021);
            }
            if (null == dto.getLevel()) {
                throw new ZydException(ErrorCode.EZYDH022);
            }
            if (null == dto.getPacking()) {
                throw new ZydException(ErrorCode.EZYDH023);
            }
            if (null == dto.getPriceRegion()) {
                throw new ZydException(ErrorCode.EZYDH024);
            }
            if (dto.getNumStored() > 1000) {
                throw new ZydException(ErrorCode.EZYDH037);
            }
            TeaBean bean = commodityConvertor.convertTeaWithAll(commodityDto);
            bean.saveRecursively();
        } else { // 精品
            BoutiqueDto dto = (BoutiqueDto) commodityDto;
            if (StringUtils.isEmpty(dto.getCmmdtyName())) {
                throw new ZydException(ErrorCode.EZYDH002);
            }
            if (dto.getCmmdtyName().length() > 25) {
                throw new ZydException(ErrorCode.EZYDH003);
            }
            if (!StringUtils.isEmpty(dto.getCmmdtyDesc()) && dto.getCmmdtyDesc().length() > 255) {
                throw new ZydException(ErrorCode.EZYDH004);
            }
            if (dto.getNumStored() < 0) {
                throw new ZydException(ErrorCode.EZYDH005);
            }
            if (null == dto.getProposedPrice()) {
                throw new ZydException(ErrorCode.EZYDH006);
            }
            if (dto.getProposedPrice().compareTo(BigDecimal.ZERO) != 1) {
                throw new ZydException(ErrorCode.EZYDH007);
            }
            if (null == dto.getCurrentPrice()) {
                throw new ZydException(ErrorCode.EZYDH008);
            }
            if (dto.getCurrentPrice().compareTo(BigDecimal.ZERO) != 1) {
                throw new ZydException(ErrorCode.EZYDH009);
            }
            if (null == dto.getShelvesTime()) {
                throw new ZydException(ErrorCode.EZYDH010);
            }
            if (StringUtils.isEmpty(dto.getDefaultImageAddrs())) {
                throw new ZydException(ErrorCode.EZYDH011);
            }
            if (dto.getDefaultImageAddrs().length() > 200) {
                throw new ZydException(ErrorCode.EZYDH012);
            }
            if (dto.getNumStored() > 1000) {
                throw new ZydException(ErrorCode.EZYDH037);
            }
            BoutiqueBean bean = commodityConvertor.convertBoutiqueWithAll(commodityDto);
            bean.saveRecursively();
        }
    }

    private void validateCommodity(CommodityDto commodityDto) throws ZydException {
        if (null == commodityDto.getCategory()) {
            throw new ZydException(ErrorCode.EZYDH001);
        }

        if (CollectionUtils.isEmpty(commodityDto.getCommodityImageDtos())) {
            throw new ZydException(ErrorCode.EZYDH029);
        }
        List<CommodityImageDto> imageDtos = commodityDto.getCommodityImageDtos();
        for (CommodityImageDto image : imageDtos) {
            if (null == image.getImageType()) {
                throw new ZydException(ErrorCode.EZYDH025);
            }
            if (StringUtils.isEmpty(image.getImageAddrs())) {
                throw new ZydException(ErrorCode.EZYDH026);
            }
            if (image.getImageAddrs().length() > 200) {
                throw new ZydException(ErrorCode.EZYDH027);
            }
        }
        if (CollectionUtils.isEmpty(commodityDto.getDetailImageDtos())) {
            throw new ZydException(ErrorCode.EZYDH031);
        }
        List<CommodityImageDto> detailImageDtos = commodityDto.getDetailImageDtos();
        for (CommodityImageDto image : detailImageDtos) {
            if (null == image.getImageType()) {
                throw new ZydException(ErrorCode.EZYDH025);
            }
            if (StringUtils.isEmpty(image.getImageAddrs())) {
                throw new ZydException(ErrorCode.EZYDH026);
            }
            if (image.getImageAddrs().length() > 200) {
                throw new ZydException(ErrorCode.EZYDH027);
            }
        }
        if (CollectionUtils.isEmpty(commodityDto.getItemListDtos())) {
            throw new ZydException(ErrorCode.EZYDH032);
        }
        List<ItemListDto> itemListDtos = commodityDto.getItemListDtos();
        for (ItemListDto item : itemListDtos) {
            if (StringUtils.isEmpty(item.getItemDesc())) {
                throw new ZydException(ErrorCode.EZYDH033);
            }
            if (item.getItemDesc().length() > 50) {
                throw new ZydException(ErrorCode.EZYDH034);
            }
            if (null == item.getItemQty()) {
                throw new ZydException(ErrorCode.EZYDH035);
            }
            if (item.getItemQty() < 0) {
                throw new ZydException(ErrorCode.EZYDH045);
            }
            if (item.getItemQty() > 1000) {
                throw new ZydException(ErrorCode.EZYDH036);
            }
        }
        if (!CollectionUtils.isEmpty(commodityDto.getCommodityPropertyDtos())) {
            List<CommodityPropertyDto> commodityPropertyDtos = commodityDto.getCommodityPropertyDtos();
            for (CommodityPropertyDto prop : commodityPropertyDtos) {
                if (StringUtils.isEmpty(prop.getPropName())) {
                    throw new ZydException(ErrorCode.EZYDH038);
                }
                if (prop.getPropName().length() > 15) {
                    throw new ZydException(ErrorCode.EZYDH039);
                }
                if (StringUtils.isEmpty(prop.getPropVal())) {
                    throw new ZydException(ErrorCode.EZYDH040);
                }
                if (prop.getPropVal().length() > 15) {
                    throw new ZydException(ErrorCode.EZYDH041);
                }
            }
        }
    }

    @Override
    public void updateCommodity(CommodityDto commodityDto) throws ZydException {
        if (null == commodityDto) {
            throw new IllegalArgumentException();
        }
        CommodityBean cmmdtyBean = commodityRepos.queryCommodityByKey(commodityDto.getCmmdtyId());
        if (null == cmmdtyBean) {
            throw new ZydException(ErrorCode.EZYDE032);
        }
        if (commodityDto.getCategory().equals(Category.A2100010)) {
            TeapotDto dto = (TeapotDto) commodityDto;
            if (!StringUtils.isEmpty(dto.getCmmdtyName()) && dto.getCmmdtyName().length() > 25) {
                throw new ZydException(ErrorCode.EZYDH003);
            }
            if (!StringUtils.isEmpty(dto.getCmmdtyDesc()) && dto.getCmmdtyDesc().length() > 255) {
                throw new ZydException(ErrorCode.EZYDH004);
            }
            if (null != dto.getNumStored() && dto.getNumStored() < 0) {
                throw new ZydException(ErrorCode.EZYDH005);
            }
            if (null != dto.getProposedPrice() && dto.getProposedPrice().compareTo(BigDecimal.ZERO) != 1) {
                throw new ZydException(ErrorCode.EZYDH007);
            }
            if (null != dto.getCurrentPrice() && dto.getCurrentPrice().compareTo(BigDecimal.ZERO) != 1) {
                throw new ZydException(ErrorCode.EZYDH009);
            }
            if (!StringUtils.isEmpty(dto.getDefaultImageAddrs()) && dto.getDefaultImageAddrs().length() > 200) {
                throw new ZydException(ErrorCode.EZYDH012);
            }
            if (null != dto.getSize() && dto.getSize() < 0) {
                throw new ZydException(ErrorCode.EZYDH017);
            }
            if (null != dto.getNumStored() && dto.getNumStored() > 1000) {
                throw new ZydException(ErrorCode.EZYDH037);
            }
            TeapotBean bean = commodityConvertor.convertTeapot(dto);
            bean.change();
        } else if (commodityDto.getCategory().equals(Category.A2100050)) { // 茶叶
            TeaDto dto = (TeaDto) commodityDto;
            if (!StringUtils.isEmpty(dto.getCmmdtyName()) && dto.getCmmdtyName().length() > 25) {
                throw new ZydException(ErrorCode.EZYDH003);
            }
            if (!StringUtils.isEmpty(dto.getCmmdtyDesc()) && dto.getCmmdtyDesc().length() > 255) {
                throw new ZydException(ErrorCode.EZYDH004);
            }
            if (null != dto.getNumStored() && dto.getNumStored() < 0) {
                throw new ZydException(ErrorCode.EZYDH005);
            }
            if (null != dto.getProposedPrice() && dto.getProposedPrice().compareTo(BigDecimal.ZERO) != 1) {
                throw new ZydException(ErrorCode.EZYDH007);
            }
            if (null != dto.getCurrentPrice() && dto.getCurrentPrice().compareTo(BigDecimal.ZERO) != 1) {
                throw new ZydException(ErrorCode.EZYDH009);
            }
            if (!StringUtils.isEmpty(dto.getDefaultImageAddrs()) && dto.getDefaultImageAddrs().length() > 200) {
                throw new ZydException(ErrorCode.EZYDH012);
            }
            if (null != dto.getNumStored() && dto.getNumStored() > 1000) {
                throw new ZydException(ErrorCode.EZYDH037);
            }
            TeaBean bean = commodityConvertor.convertTea(dto);
            bean.change();
        } else { // 精品
            BoutiqueDto dto = (BoutiqueDto) commodityDto;
            if (!StringUtils.isEmpty(dto.getCmmdtyName()) && dto.getCmmdtyName().length() > 25) {
                throw new ZydException(ErrorCode.EZYDH003);
            }
            if (!StringUtils.isEmpty(dto.getCmmdtyDesc()) && dto.getCmmdtyDesc().length() > 255) {
                throw new ZydException(ErrorCode.EZYDH004);
            }
            if (null != dto.getNumStored() && dto.getNumStored() < 0) {
                throw new ZydException(ErrorCode.EZYDH005);
            }
            if (null != dto.getProposedPrice() && dto.getProposedPrice().compareTo(BigDecimal.ZERO) != 1) {
                throw new ZydException(ErrorCode.EZYDH007);
            }
            if (null != dto.getCurrentPrice() && dto.getCurrentPrice().compareTo(BigDecimal.ZERO) != 1) {
                throw new ZydException(ErrorCode.EZYDH009);
            }
            if (!StringUtils.isEmpty(dto.getDefaultImageAddrs()) && dto.getDefaultImageAddrs().length() > 200) {
                throw new ZydException(ErrorCode.EZYDH012);
            }
            if (null != dto.getNumStored() && dto.getNumStored() > 1000) {
                throw new ZydException(ErrorCode.EZYDH037);
            }
            BoutiqueBean bean = commodityConvertor.convertBoutique(dto);
            bean.change();
        }
    }

    @Override
    public void approveCommodity(String auditor, BigDecimal cmmdtyId) throws ZydException {
        if (StringUtils.isEmpty(auditor) || null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        CommodityBean bean = commodityRepos.queryCommodityByKey(cmmdtyId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDE032);
        }
        if (!StringUtils.isEmpty(bean.getAuditor())) {
            throw new ZydException(ErrorCode.EZYDH042);
        }
        bean.approve(auditor);
    }

    @Override
    public CommodityDto queryCommodityByCmmdtyNum(String cmmdtyNum) throws ZydException {
        if (StringUtils.isEmpty(cmmdtyNum)) {
            throw new IllegalArgumentException();
        }
        CommodityBean bean = commodityRepos.queryCommodityByCmmdtyNum(cmmdtyNum);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDH043);
        }
        if (cmmdtyNum.startsWith(CommonConstants.CMMDTY_NUM_PREFIX_H)) {
            return commodityConvertor.convertTeapot((TeapotBean) bean);
        } else if (cmmdtyNum.startsWith(CommonConstants.CMMDTY_NUM_PREFIX_G)) {
            return commodityConvertor.convertBoutique((BoutiqueBean) bean);
        } else if (cmmdtyNum.startsWith(CommonConstants.CMMDTY_NUM_PREFIX_C)) {
            return commodityConvertor.convertTea((TeaBean) bean);
        }
        return null;
    }

    @Override
    public CommodityDto queryCommodityByKey(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        CommodityBean bean = commodityRepos.queryCommodityByKey(cmmdtyId);
        if (null == bean) {
            return null;
        }
        if (bean instanceof TeapotBean) {
            return commodityConvertor.convertTeapot((TeapotBean) bean);
        } else if (bean instanceof BoutiqueBean) {
            return commodityConvertor.convertBoutique((BoutiqueBean) bean);
        } else if (bean instanceof TeaBean) {
            return commodityConvertor.convertTea((TeaBean) bean);
        }
        return null;
    }

    @Override
    public TeapotDto queryTeapotByKey(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        TeapotBean bean = commodityRepos.queryTeapotByKey(cmmdtyId);
        if (null == bean) {
            return null;
        }
        return (TeapotDto) commodityConvertor.convertTeapot(bean);
    }

    @Override
    public TeaDto queryTeaByKey(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        TeaBean bean = commodityRepos.queryTeaByKey(cmmdtyId);
        if (null == bean) {
            return null;
        }
        return (TeaDto) commodityConvertor.convertTea(bean);
    }

    @Override
    public BoutiqueDto queryBoutiqueByKey(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        BoutiqueBean bean = commodityRepos.queryBoutiqueByKey(cmmdtyId);
        if (null == bean) {
            return null;
        }
        return (BoutiqueDto) commodityConvertor.convertBoutique(bean);
    }

    @Override
    public List<TeapotDto> queryTeapots(TeapotSearchVo queryParam, CommoditySortCriteria criteria, int pageSize,
            int page) throws ZydException {
        if (null == queryParam) {
            throw new IllegalArgumentException();
        }
        List<TeapotBean> beans = commodityRepos.queryTeapotBeans(queryParam, criteria, pageSize, page);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<TeapotDto> dtos = new ArrayList<TeapotDto>();
        for (TeapotBean bean : beans) {
            TeapotDto td = (TeapotDto) commodityConvertor.convertTeapot(bean);
            LabelBean label = commodityRepos.queryLabelBeanByCommodity(bean.getCmmdtyId());
            if (null != label) {
                td.setLabelDto(commodityConvertor.convertLabel(label));
            }
            dtos.add(td);
        }
        return dtos;

    }

    @Override
    public int queryCountOfTeapots(TeapotSearchVo queryParam) throws ZydException {
        if (null == queryParam) {
            throw new IllegalArgumentException();
        }
        return commodityRepos.queryCountOfTeapotBeans(queryParam);
    }

    @Override
    public List<BoutiqueDto> queryBoutiques(BoutiqueSearchVo queryParam, CommoditySortCriteria criteria, int pageSize,
            int page) throws ZydException {
        if (null == queryParam) {
            throw new IllegalArgumentException();
        }
        List<BoutiqueBean> beans = commodityRepos.queryBoutiqueBeans(queryParam, criteria, pageSize, page);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<BoutiqueDto> dtos = new ArrayList<BoutiqueDto>();
        for (BoutiqueBean bean : beans) {
            dtos.add((BoutiqueDto) commodityConvertor.convertBoutique(bean));
        }
        return dtos;

    }

    @Override
    public List<TeaDto> queryTeas(TeaSearchVo queryParam, CommoditySortCriteria criteria, int pageSize, int page)
            throws ZydException {
        if (null == queryParam) {
            throw new IllegalArgumentException();
        }
        List<TeaBean> beans = commodityRepos.queryTeaBeans(queryParam, criteria, pageSize, page);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<TeaDto> dtos = new ArrayList<TeaDto>();
        for (TeaBean bean : beans) {
            dtos.add((TeaDto) commodityConvertor.convertTea(bean));
        }
        return dtos;

    }

    @Override
    public List<CommodityPropertyDto> queryCommodityProperties(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        List<CommodityPropertyBean> beans = commodityRepos.queryCommodityPropertyBeans(cmmdtyId);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<CommodityPropertyDto> dtos = new ArrayList<CommodityPropertyDto>();
        for (CommodityPropertyBean bean : beans) {
            dtos.add((CommodityPropertyDto) commodityConvertor.convertCommodityProperty(bean));
        }
        return dtos;
    }

    @Override
    public void updateCommodityProperty(BigDecimal cmmdtyId, BigDecimal propertyId, String propVal) throws ZydException {
        if (null == cmmdtyId || null == propertyId) {
            throw new IllegalArgumentException();
        }
        if (StringUtils.isEmpty(propVal)) {
            throw new ZydException(ErrorCode.EZYDH040);
        }
        if (propVal.length() > 30) {
            throw new ZydException(ErrorCode.EZYDH041);
        }
        CommodityBean commdtyBean = commodityRepos.queryCommodityByKey(cmmdtyId);
        if (null == commdtyBean) {
            throw new ZydException(ErrorCode.EZYDE032);
        }
        CommodityPropertyBean propertyBean = commodityRepos.queryCommodityPropertyByKey(propertyId);
        if (null == propertyBean) {
            throw new ZydException(ErrorCode.EZYDH044);
        }
        if (!propertyBean.getCmmdtyId().equals(cmmdtyId)) {
            // TODO 新增错误码,属性不属于该商品
            throw new ZydException(ErrorCode.EZYDH044);
        }
        commdtyBean.updateProperty(propertyId, propVal);
    }

    @Override
    public void resetCommodityProperties(BigDecimal cmmdtyId, List<CommodityPropertyDto> properties)
            throws ZydException {
        if (null == cmmdtyId || CollectionUtils.isEmpty(properties)) {
            throw new IllegalArgumentException();
        }
        CommodityBean commodityBean = commodityRepos.queryCommodityByKey(cmmdtyId);
        if (null == commodityBean) {
            throw new ZydException(ErrorCode.EZYDE032);
        }
        for (CommodityPropertyDto dto : properties) {
            if (StringUtils.isEmpty(dto.getPropName())) {
                throw new ZydException(ErrorCode.EZYDH038);
            }
            if (dto.getPropName().length() > 15) {
                throw new ZydException(ErrorCode.EZYDH039);
            }
            if (StringUtils.isEmpty(dto.getPropVal())) {
                throw new ZydException(ErrorCode.EZYDH040);
            }
            if (dto.getPropVal().length() > 30) {
                throw new ZydException(ErrorCode.EZYDH041);
            }
        }
        commodityBean.cleanCommodityProperties();
        int seq = 1;
        for (CommodityPropertyDto dto : properties) {
            commodityBean.addProperty(dto.getPropName(), dto.getPropVal(), seq++);
        }
    }

    @Override
    public void cleanCommodityProperties(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        CommodityBean commodityBean = commodityRepos.queryCommodityByKey(cmmdtyId);
        if (null == commodityBean) {
            throw new ZydException(ErrorCode.EZYDE032);
        }
        commodityBean.cleanCommodityProperties();
    }

    @Override
    public List<ItemListDto> queryCommodityItemList(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        List<ItemListBean> beans = commodityRepos.queryItemListBeans(cmmdtyId);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<ItemListDto> dtos = new ArrayList<ItemListDto>();
        for (ItemListBean bean : beans) {
            dtos.add((ItemListDto) commodityConvertor.convertCommodityProperty(bean));
        }
        return dtos;
    }

    @Override
    public void updateCommodityItemList(BigDecimal cmmdtyId, BigDecimal itemId, int qty) throws ZydException {
        if (null == cmmdtyId || null == itemId) {
            throw new IllegalArgumentException();
        }
        if (qty < 0) {
            throw new ZydException(ErrorCode.EZYDH045);
        }
        if (qty > 1000) {
            throw new ZydException(ErrorCode.EZYDH036);
        }

        CommodityBean commdtyBean = commodityRepos.queryCommodityByKey(cmmdtyId);
        if (null == commdtyBean) {
            throw new ZydException(ErrorCode.EZYDE032);
        }
        ItemListBean itemListBean = commodityRepos.queryItemListByKey(itemId);
        if (null == itemListBean) {
            throw new ZydException(ErrorCode.EZYDH046);
        }
        if (!itemListBean.getCmmdtyId().equals(cmmdtyId)) {
            // TODO 新增错误码,包装清单不属于该商品
            throw new ZydException(ErrorCode.EZYDH044);
        }
        commdtyBean.updateCommodityItemList(itemId, qty);
    }

    @Override
    public void addCommodityItemList(BigDecimal cmmdtyId, String itemDesc, int qty) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        if (StringUtils.isEmpty(itemDesc)) {
            throw new ZydException(ErrorCode.EZYDH033);
        }
        if (itemDesc.length() > 50) {
            throw new ZydException(ErrorCode.EZYDH034);
        }
        if (qty < 0) {
            throw new ZydException(ErrorCode.EZYDH045);
        }
        if (qty > 1000) {
            throw new ZydException(ErrorCode.EZYDH036);
        }
        CommodityBean commdtyBean = commodityRepos.queryCommodityByKey(cmmdtyId);
        if (null == commdtyBean) {
            throw new ZydException(ErrorCode.EZYDE032);
        }
        ItemListBean itemListBean = commodityRepos.queryItemListByDesc(cmmdtyId, itemDesc);
        if (null != itemListBean) {
            throw new ZydException(ErrorCode.EZYDH047);
        }
        commdtyBean.addCommodityItemList(itemDesc, qty);
    }

    @Override
    public void removeCommodityItemList(BigDecimal cmmdtyId, BigDecimal itemId) throws ZydException {
        if (null == cmmdtyId || null == itemId) {
            throw new IllegalArgumentException();
        }
        CommodityBean commdtyBean = commodityRepos.queryCommodityByKey(cmmdtyId);
        if (null == commdtyBean) {
            throw new ZydException(ErrorCode.EZYDE032);
        }
        ItemListBean itemListBean = commodityRepos.queryItemListByKey(itemId);
        if (null == itemListBean) {
            throw new ZydException(ErrorCode.EZYDH046);
        }
        if (!itemListBean.getCmmdtyId().equals(cmmdtyId)) {
            // TODO 新增错误码,包装清单不属于该商品
            throw new ZydException(ErrorCode.EZYDH044);
        }
        commdtyBean.removeCommodityItemList(itemId);
    }

    @Override
    public List<CommodityImageDto> queryCommodityImages(BigDecimal cmmdtyId, CommodityImageType type)
            throws ZydException {
        if (null == cmmdtyId || null == type) {
            throw new IllegalArgumentException();
        }
        List<CommodityImageBean> beans = commodityRepos.queryCommodityImageBeans(cmmdtyId, type);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<CommodityImageDto> dtos = new ArrayList<CommodityImageDto>();
        for (CommodityImageBean bean : beans) {
            dtos.add((CommodityImageDto) commodityConvertor.convertCommodityImage(bean));
        }
        return dtos;
    }

    @Override
    public void resetCommodityImages(BigDecimal cmmdtyId, CommodityImageType type, List<String> imagesAddrs)
            throws ZydException {
        if (null == cmmdtyId || null == type || CollectionUtils.isEmpty(imagesAddrs)) {
            throw new IllegalArgumentException();
        }
        CommodityBean commodityBean = commodityRepos.queryCommodityByKey(cmmdtyId);
        if (null == commodityBean) {
            throw new ZydException(ErrorCode.EZYDE032);
        }
        for (String addr : imagesAddrs) {
            if (StringUtils.isEmpty(addr)) {
                throw new ZydException(ErrorCode.EZYDH026);
            }
            if (addr.length() > 200) {
                throw new ZydException(ErrorCode.EZYDH027);
            }
        }
        commodityBean.cleanImageByType(type);
        int seq = 1;
        for (String addr : imagesAddrs) {
            commodityBean.addImage(type, addr, seq);
        }
    }

    @Override
    public List<CommodityDto> queryCollectedCommoditiesByParty(BigDecimal partyId, int pageSize, int page)
            throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }

        List<CommodityBean> beans = commodityRepos.queryCollectedCommoditiesByParty(partyId, pageSize, page);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }

        List<CommodityDto> dtos = new ArrayList<CommodityDto>();
        for (CommodityBean bean : beans) {
            if (bean instanceof TeapotBean) {
                dtos.add(commodityConvertor.convertTeapot((TeapotBean) bean));
            } else if (bean instanceof BoutiqueBean) {
                dtos.add(commodityConvertor.convertBoutique((BoutiqueBean) bean));
            } else if (bean instanceof TeaBean) {
                dtos.add(commodityConvertor.convertTea((TeaBean) bean));
            }
        }
        return dtos;
    }

    @Override
    public List<CommodityEnquiringDto> queryCommodityEnquiringsByCommodity(BigDecimal cmmdtyId, int pageSize, int page)
            throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }

        List<CommodityEnquiringBean> beans = commodityRepos.queryCommodityEnquiringBeansByCommodity(cmmdtyId, pageSize,
                page);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }

        List<CommodityEnquiringDto> dtos = new ArrayList<CommodityEnquiringDto>();
        for (CommodityEnquiringBean bean : beans) {
            dtos.add(commodityConvertor.convertCommodityEnquiring(bean));
        }
        return dtos;
    }

    @Override
    public List<CommodityEnquiringDto> queryCommodityEnquiringsByParty(BigDecimal partyId, int pageSize, int page)
            throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }

        List<CommodityEnquiringBean> beans = commodityRepos
                .queryCommodityEnquiringBeansByParty(partyId, pageSize, page);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }

        List<CommodityEnquiringDto> dtos = new ArrayList<CommodityEnquiringDto>();
        for (CommodityEnquiringBean bean : beans) {
            dtos.add(commodityConvertor.convertCommodityEnquiring(bean));
        }
        return dtos;
    }

    @Override
    public void answerEnquiring(BigDecimal enquiringId, String answerer, String answer) throws ZydException {
        if (null == enquiringId) {
            throw new IllegalArgumentException();
        }
        if (StringUtils.isEmpty(answerer)) {
            throw new ZydException(ErrorCode.EZYDH051);
        }
        if (answerer.length() > 10) {
            throw new ZydException(ErrorCode.EZYDH052);
        }
        if (StringUtils.isEmpty(answer)) {
            throw new ZydException(ErrorCode.EZYDH053);
        }
        if (answer.length() > 300) {
            throw new ZydException(ErrorCode.EZYDH054);
        }
        CommodityEnquiringBean bean = commodityRepos.queryCommodityEnquiringBeansByKey(enquiringId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDH050);
        }
        bean.setAnswer(answer);
        bean.setAnswerer(answerer);
        bean.change();
    }

    @Override
    public LabelDto queryLabelByCommodity(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        LabelBean labelBean = commodityRepos.queryLabelBeanByCommodity(cmmdtyId);
        if (null == labelBean) {
            return null;
        }
        return commodityConvertor.convertLabel(labelBean);
    }

    @Override
    public void removeLabelFromCommodity(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        CommodityBean bean = commodityRepos.queryCommodityByKey(cmmdtyId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDE032);
        }
        bean.removeLabel();
    }

    @Override
    public void setLabel(BigDecimal cmmdtyId, BigDecimal labelId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        CommodityBean commodityBean = commodityRepos.queryCommodityByKey(cmmdtyId);
        if (null == commodityBean) {
            throw new ZydException(ErrorCode.EZYDE032);
        }
        LabelBean label = commodityRepos.queryLabelBeanByKey(labelId);
        if (null != label) {
            throw new ZydException(ErrorCode.EZYDH055);
        }
        LabelBean labelBean = commodityRepos.queryLabelBeanByCommodity(cmmdtyId);
        if (null != labelBean) {
            throw new ZydException(ErrorCode.EZYDH056);
        }
        commodityBean.setLabel(labelId);
    }

    /**
     * @Override public void setLabel(BigDecimal cmmdtyId, LabelStyle labelStyle, String labelVal) throws ZydException {
     *           if (null == cmmdtyId) { throw new IllegalArgumentException(); } CommodityBean commodityBean =
     *           commodityRepos.queryCommodityByKey(cmmdtyId); if (null == commodityBean) { throw new
     *           ZydException(ErrorCode.EZYDE032); }
     * 
     *           LabelBean labelBean = commodityRepos.queryLabelBeanByCommodity(cmmdtyId); if (null != labelBean) {
     *           throw new ZydException(ErrorCode.EZYDH056); } commodityBean.setLabel(labelStyle, labelVal); }
     */

    @Override
    public void addRecommended(BigDecimal srcCmmdtyId, BigDecimal recommendedCmmdtyId) throws ZydException {
        if (null == srcCmmdtyId || null == recommendedCmmdtyId) {
            throw new IllegalArgumentException();
        }
        CommodityBean srcCommodityBean = commodityRepos.queryCommodityByKey(srcCmmdtyId);
        if (null == srcCommodityBean) {
            throw new ZydException(ErrorCode.EZYDE032);
        }
        CommodityBean recommendedCommodityBean = commodityRepos.queryCommodityByKey(recommendedCmmdtyId);
        if (null == recommendedCommodityBean) {
            throw new ZydException(ErrorCode.EZYDH063);
        }
        if (srcCommodityBean.isRecommendRel(recommendedCmmdtyId)) {
            throw new ZydException(ErrorCode.EZYDH057);
        }
        List<CommodityBean> recommendedCommodityBeans = commodityRepos
                .queryRecommendedCommodityBeansByCommodity(srcCmmdtyId);
        if (!CollectionUtils.isEmpty(recommendedCommodityBeans) && recommendedCommodityBeans.size() >= 5) {
            throw new ZydException(ErrorCode.EZYDH059);
        }
        srcCommodityBean.addRecommended(recommendedCmmdtyId);
    }

    @Override
    public void removeRecommended(BigDecimal srcCmmdtyId, BigDecimal recommendedCmmdtyId) throws ZydException {
        if (null == srcCmmdtyId || null == recommendedCmmdtyId) {
            throw new IllegalArgumentException();
        }
        CommodityBean srcCommodityBean = commodityRepos.queryCommodityByKey(srcCmmdtyId);
        if (null == srcCommodityBean) {
            throw new ZydException(ErrorCode.EZYDE032);
        }
        CommodityBean recommendedCommodityBean = commodityRepos.queryCommodityByKey(recommendedCmmdtyId);
        if (null == recommendedCommodityBean) {
            throw new ZydException(ErrorCode.EZYDH063);
        }
        if (!srcCommodityBean.isRecommendRel(recommendedCmmdtyId)) {
            throw new ZydException(ErrorCode.EZYDH058);
        }
        srcCommodityBean.removeRecommended(recommendedCmmdtyId);
    }

    @Override
    public List<CommodityDto> queryRecommended(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        List<CommodityBean> beans = commodityRepos.queryRecommendedCommodityBeansByCommodity(cmmdtyId);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }

        List<CommodityDto> dtos = new ArrayList<CommodityDto>();
        for (CommodityBean bean : beans) {
            if (bean instanceof TeapotBean) {
                dtos.add(commodityConvertor.convertTeapot((TeapotBean) bean));
            } else if (bean instanceof BoutiqueBean) {
                dtos.add(commodityConvertor.convertBoutique((BoutiqueBean) bean));
            } else if (bean instanceof TeaBean) {
                dtos.add(commodityConvertor.convertTea((TeaBean) bean));
            }
        }
        return dtos;
    }

    @Override
    public void addGift(BigDecimal srcCmmdtyId, BigDecimal giftCmmdtyId) throws ZydException {
        if (null == srcCmmdtyId || null == giftCmmdtyId) {
            throw new IllegalArgumentException();
        }
        CommodityBean srcCommodityBean = commodityRepos.queryCommodityByKey(srcCmmdtyId);
        if (null == srcCommodityBean) {
            throw new ZydException(ErrorCode.EZYDE032);
        }
        CommodityBean giftCommodityBean = commodityRepos.queryCommodityByKey(giftCmmdtyId);
        if (null == giftCommodityBean) {
            throw new ZydException(ErrorCode.EZYDH064);
        }
        if (srcCommodityBean.isGiftContaining(giftCmmdtyId)) {
            throw new ZydException(ErrorCode.EZYDH060);
        }
        List<CommodityBean> giftCommodityBeans = commodityRepos.queryGiftsByCommodity(srcCmmdtyId);
        if (!CollectionUtils.isEmpty(giftCommodityBeans) && giftCommodityBeans.size() >= 5) {
            throw new ZydException(ErrorCode.EZYDH062);
        }
        srcCommodityBean.addGift(giftCmmdtyId);
    }

    @Override
    public void removeGift(BigDecimal srcCmmdtyId, BigDecimal giftCmmdtyId) throws ZydException {
        if (null == srcCmmdtyId || null == giftCmmdtyId) {
            throw new IllegalArgumentException();
        }
        CommodityBean srcCommodityBean = commodityRepos.queryCommodityByKey(srcCmmdtyId);
        if (null == srcCommodityBean) {
            throw new ZydException(ErrorCode.EZYDE032);
        }
        CommodityBean giftCommodityBean = commodityRepos.queryCommodityByKey(giftCmmdtyId);
        if (null == giftCommodityBean) {
            throw new ZydException(ErrorCode.EZYDH064);
        }
        if (!srcCommodityBean.isGiftContaining(giftCmmdtyId)) {
            throw new ZydException(ErrorCode.EZYDH061);
        }
        srcCommodityBean.removeGift(giftCmmdtyId);
    }

    @Override
    public List<CommodityDto> queryGift(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        List<CommodityBean> beans = commodityRepos.queryGiftsByCommodity(cmmdtyId);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }

        List<CommodityDto> dtos = new ArrayList<CommodityDto>();
        for (CommodityBean bean : beans) {
            if (bean instanceof TeapotBean) {
                dtos.add(commodityConvertor.convertTeapot((TeapotBean) bean));
            } else if (bean instanceof BoutiqueBean) {
                dtos.add(commodityConvertor.convertBoutique((BoutiqueBean) bean));
            } else if (bean instanceof TeaBean) {
                dtos.add(commodityConvertor.convertTea((TeaBean) bean));
            }
        }
        return dtos;
    }

}
