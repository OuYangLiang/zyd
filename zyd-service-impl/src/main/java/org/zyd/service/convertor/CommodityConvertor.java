package org.zyd.service.convertor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.common.constants.CommodityImageType;
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
import org.zyd.service.dto.BoutiqueDto;
import org.zyd.service.dto.CommodityDto;
import org.zyd.service.dto.CommodityEnquiringDto;
import org.zyd.service.dto.CommodityImageDto;
import org.zyd.service.dto.CommodityPropertyDto;
import org.zyd.service.dto.ItemListDto;
import org.zyd.service.dto.LabelDto;
import org.zyd.service.dto.TeaDto;
import org.zyd.service.dto.TeapotDto;

public class CommodityConvertor {
    @Autowired
    private CommodityFactory commodityFactory;

    public CommodityDto convertTeapot(TeapotBean bean) {
        if (null == bean) {
            return null;
        }
        TeapotDto dto = new TeapotDto();
        dto.setCmmdtyId(bean.getCmmdtyId());
        dto.setCmmdtyDesc(bean.getCmmdtyDesc());
        dto.setCmmdtyName(bean.getCmmdtyName());
        dto.setCmmdtyNum(bean.getCmmdtyNum());
        dto.setCurrentPrice(bean.getCurrentPrice());
        dto.setDefaultImageAddrs(bean.getDefaultImageAddrs());
        dto.setLevel(bean.getLevel());
        dto.setNumEvaluated(bean.getNumEvaluated());
        dto.setNumEnquired(bean.getNumEnquired());
        dto.setNumSales(bean.getNumSales());
        dto.setNumStored(bean.getNumStored());
        dto.setPriceRegion(bean.getPriceRegion());
        dto.setProposedPrice(bean.getProposedPrice());
        dto.setShelvesTime(bean.getShelvesTime());
        dto.setMaterial(bean.getMaterial());
        dto.setProducer(bean.getProducer());
        dto.setSalesMode(bean.getSalesMode());
        dto.setShape(bean.getShape());
        dto.setSize(bean.getSize());
        dto.setType(bean.getType());
        dto.setUnshelvesTime(bean.getUnshelvesTime());
        return dto;
    }

    public CommodityDto convertTea(TeaBean bean) {
        if (null == bean) {
            return null;
        }
        TeaDto dto = new TeaDto();
        dto.setCmmdtyDesc(bean.getCmmdtyDesc());
        dto.setCmmdtyId(bean.getCmmdtyId());
        dto.setCmmdtyName(bean.getCmmdtyName());
        dto.setCmmdtyNum(bean.getCmmdtyNum());
        dto.setCurrentPrice(bean.getCurrentPrice());
        dto.setDefaultImageAddrs(bean.getDefaultImageAddrs());
        dto.setLevel(bean.getLevel());
        dto.setNumEvaluated(bean.getNumEvaluated());
        dto.setNumSales(bean.getNumSales());
        dto.setNumStored(bean.getNumStored());
        dto.setPacking(bean.getPacking());
        dto.setPlaceOfOrigin(bean.getPlaceOfOrigin());
        dto.setPriceRegion(bean.getPriceRegion());
        dto.setProposedPrice(bean.getProposedPrice());
        dto.setShelvesTime(bean.getShelvesTime());
        dto.setTeaType(bean.getTeaType());
        dto.setUnshelvesTime(bean.getUnshelvesTime());
        return dto;
    }

    public CommodityDto convertBoutique(BoutiqueBean bean) {
        if (null == bean) {
            return null;
        }
        BoutiqueDto dto = new BoutiqueDto();
        dto.setCmmdtyDesc(bean.getCmmdtyDesc());
        dto.setCmmdtyName(bean.getCmmdtyName());
        dto.setCmmdtyNum(bean.getCmmdtyNum());
        dto.setCurrentPrice(bean.getCurrentPrice());
        dto.setDefaultImageAddrs(bean.getDefaultImageAddrs());
        dto.setNumEvaluated(bean.getNumEvaluated());
        dto.setNumSales(bean.getNumSales());
        dto.setNumStored(bean.getNumStored());
        dto.setProposedPrice(bean.getProposedPrice());
        dto.setShelvesTime(bean.getShelvesTime());
        dto.setUnshelvesTime(bean.getUnshelvesTime());
        return dto;
    }

    public CommodityPropertyDto convertCommodityProperty(CommodityPropertyBean bean) {
        if (null == bean) {
            return null;
        }
        CommodityPropertyDto dto = new CommodityPropertyDto();
        dto.setCmmdtyId(bean.getCmmdtyId());
        dto.setPropertyId(bean.getPropertyId());
        dto.setPropName(bean.getPropName());
        dto.setPropVal(bean.getPropVal());
        dto.setSeq(bean.getSeq());
        return dto;
    }

    public ItemListDto convertCommodityProperty(ItemListBean bean) {
        if (null == bean) {
            return null;
        }
        ItemListDto dto = new ItemListDto();
        dto.setCmmdtyId(bean.getCmmdtyId());
        dto.setItemDesc(bean.getItemDesc());
        dto.setItemId(bean.getItemId());
        dto.setItemQty(bean.getItemQty());
        return dto;
    }

    public CommodityImageDto convertCommodityImage(CommodityImageBean bean) {
        if (null == bean) {
            return null;
        }
        CommodityImageDto dto = new CommodityImageDto();
        dto.setCmmdtyId(bean.getCmmdtyId());
        dto.setImageAddrs(bean.getImageAddrs());
        dto.setImageId(bean.getImageId());
        dto.setImageSeq(bean.getImageSeq());
        dto.setImageType(bean.getImageType());
        return dto;
    }

    public CommodityEnquiringDto convertCommodityEnquiring(CommodityEnquiringBean bean) {
        if (null == bean) {
            return null;
        }
        CommodityEnquiringDto dto = new CommodityEnquiringDto();
        dto.setCmmdtyId(bean.getCmmdtyId());
        dto.setAnswer(bean.getAnswer());
        dto.setAnswerer(bean.getAnswerer());
        dto.setAnswerTs(bean.getAnswerTs());
        dto.setEnquiringContent(bean.getEnquiringContent());
        dto.setEnquiringId(bean.getEnquiringId());
        dto.setEventTs(bean.getEventTs());
        dto.setPartyId(bean.getPartyId());
        dto.setAcntVal(bean.getAcntVal());
        return dto;
    }

    public LabelDto convertLabel(LabelBean bean) {
        if (null == bean) {
            return null;
        }
        LabelDto dto = new LabelDto();
        dto.setLabelId(bean.getLabelId());
//        dto.setLabelStyle(bean.getLabelStyle());
        dto.setLabelVal(bean.getLabelVal());
        return dto;
    }

    public TeapotBean convertTeapot(TeapotDto dto) {
        if (null == dto) {
            return null;
        }
        TeapotBean bean = commodityFactory.createTeapotBean();
        bean.setCmmdtyDesc(dto.getCmmdtyDesc());
        bean.setCmmdtyName(dto.getCmmdtyName());
        bean.setCmmdtyNum(dto.getCmmdtyNum());
        bean.setCurrentPrice(dto.getCurrentPrice());
        bean.setDefaultImageAddrs(dto.getDefaultImageAddrs());
        bean.setLevel(dto.getLevel());
        bean.setNumEvaluated(dto.getNumEvaluated());
        bean.setNumSales(dto.getNumSales());
        bean.setNumStored(dto.getNumStored());
        bean.setPriceRegion(dto.getPriceRegion());
        bean.setProposedPrice(dto.getProposedPrice());
        bean.setShelvesTime(dto.getShelvesTime());
        bean.setMaterial(dto.getMaterial());
        bean.setProducer(dto.getProducer());
        bean.setSalesMode(dto.getSalesMode());
        bean.setShape(dto.getShape());
        bean.setSize(dto.getSize());
        bean.setType(dto.getType());
        bean.setUnshelvesTime(dto.getUnshelvesTime());
        return bean;
    }

    public TeaBean convertTea(TeaDto dto) {
        if (null == dto) {
            return null;
        }
        TeaBean bean = commodityFactory.createTeaBean();
        bean.setCmmdtyDesc(dto.getCmmdtyDesc());
        bean.setCmmdtyId(dto.getCmmdtyId());
        bean.setCmmdtyName(dto.getCmmdtyName());
        bean.setCmmdtyNum(dto.getCmmdtyNum());
        bean.setCurrentPrice(dto.getCurrentPrice());
        bean.setDefaultImageAddrs(dto.getDefaultImageAddrs());
        bean.setLevel(dto.getLevel());
        bean.setNumEvaluated(dto.getNumEvaluated());
        bean.setNumSales(dto.getNumSales());
        bean.setNumStored(dto.getNumStored());
        bean.setPacking(dto.getPacking());
        bean.setPlaceOfOrigin(dto.getPlaceOfOrigin());
        bean.setPriceRegion(dto.getPriceRegion());
        bean.setProposedPrice(dto.getProposedPrice());
        bean.setShelvesTime(dto.getShelvesTime());
        bean.setTeaType(dto.getTeaType());
        bean.setUnshelvesTime(dto.getUnshelvesTime());
        return bean;
    }

    public BoutiqueBean convertBoutique(BoutiqueDto dto) {
        if (null == dto) {
            return null;
        }
        BoutiqueBean bean = commodityFactory.createBoutiqueBean();
        bean.setCmmdtyDesc(dto.getCmmdtyDesc());
        bean.setCmmdtyName(dto.getCmmdtyName());
        bean.setCmmdtyNum(dto.getCmmdtyNum());
        bean.setCurrentPrice(dto.getCurrentPrice());
        bean.setDefaultImageAddrs(dto.getDefaultImageAddrs());
        bean.setNumEvaluated(dto.getNumEvaluated());
        bean.setNumSales(dto.getNumSales());
        bean.setNumStored(dto.getNumStored());
        bean.setProposedPrice(dto.getProposedPrice());
        bean.setShelvesTime(dto.getShelvesTime());
        bean.setUnshelvesTime(dto.getUnshelvesTime());
        return bean;
    }

    public CommodityImageBean convertCommodityImage(CommodityImageDto dto) {
        if (null == dto) {
            return null;
        }
        CommodityImageBean bean = commodityFactory.createCommodityImageBean();
        bean.setImageAddrs(dto.getImageAddrs());
        bean.setCmmdtyId(dto.getCmmdtyId());
        bean.setImageId(dto.getImageId());
        bean.setImageType(dto.getImageType());
        bean.setImageSeq(dto.getImageSeq());
        return bean;
    }

    public ItemListBean convertItemList(ItemListDto dto) {
        if (null == dto) {
            return null;
        }
        ItemListBean bean = commodityFactory.createItemListBean();
        bean.setCmmdtyId(dto.getCmmdtyId());
        bean.setItemDesc(dto.getItemDesc());
        bean.setItemId(dto.getItemId());
        bean.setItemQty(dto.getItemQty());
        return bean;
    }

    public CommodityPropertyBean convertCommodityProperty(CommodityPropertyDto dto) {
        if (null == dto) {
            return null;
        }
        CommodityPropertyBean bean = commodityFactory.createCommodityPropertyBean();
        bean.setCmmdtyId(dto.getCmmdtyId());
        bean.setPropertyId(dto.getPropertyId());
        bean.setPropName(dto.getPropName());
        bean.setPropVal(dto.getPropVal());
        bean.setSeq(dto.getSeq());
        return bean;
    }

    public LabelBean convertLabel(LabelDto dto) {
        if (null == dto) {
            return null;
        }
        LabelBean bean = commodityFactory.createLabelBean();
        bean.setLabelId(dto.getLabelId());
        bean.setLabelStyle(dto.getLabelStyle());
        bean.setLabelVal(dto.getLabelVal());
        return bean;
    }

    public TeapotBean convertTeapotWithAll(CommodityDto commodityDto) {
        if (null == commodityDto) {
            return null;
        }
        TeapotDto dto = (TeapotDto) commodityDto;
        TeapotBean bean = this.convertTeapot(dto);
        this.setCommoditySurrounding(bean, commodityDto);
        return bean;
    }

    public TeaBean convertTeaWithAll(CommodityDto commodityDto) {
        if (null == commodityDto) {
            return null;
        }
        TeaDto dto = (TeaDto) commodityDto;
        TeaBean bean = this.convertTea(dto);
        this.setCommoditySurrounding(bean, commodityDto);
        return bean;
    }

    public BoutiqueBean convertBoutiqueWithAll(CommodityDto commodityDto) {
        if (null == commodityDto) {
            return null;
        }
        BoutiqueDto dto = (BoutiqueDto) commodityDto;
        BoutiqueBean bean = this.convertBoutique(dto);
        this.setCommoditySurrounding(bean, commodityDto);
        return bean;
    }

    private void setCommoditySurrounding(CommodityBean bean, CommodityDto commodityDto) {
        if (null != commodityDto.getCommodityImageDtos()) {
            List<CommodityImageDto> commodityImageDtos = commodityDto.getCommodityImageDtos();
            List<CommodityImageBean> images = new ArrayList<CommodityImageBean>();
            int a = 1, b = 1, c = 1;
            for (CommodityImageDto image : commodityImageDtos) {
                CommodityImageBean imageBean = this.convertCommodityImage(image);
                if (CommodityImageType.A5800010.equals(imageBean.getImageType())) {
                    imageBean.setImageSeq(a++);
                } else if (CommodityImageType.A5800020.equals(imageBean.getImageType())) {
                    imageBean.setImageSeq(b++);
                } else {
                    imageBean.setImageSeq(c++);
                }
                images.add(imageBean);
            }
            bean.setCommodityImageBeans(images);
        }
        if (null != commodityDto.getDetailImageDtos()) {
            List<CommodityImageDto> detailImageDtos = commodityDto.getDetailImageDtos();
            List<CommodityImageBean> images = new ArrayList<CommodityImageBean>();
            int i = 1;
            for (CommodityImageDto image : detailImageDtos) {
                CommodityImageBean imageBean = this.convertCommodityImage(image);
                imageBean.setImageSeq(i++);
                images.add(imageBean);
            }
            bean.setDetailImageBeans(images);
        }
        if (null != commodityDto.getItemListDtos()) {
            List<ItemListDto> itemListDtos = commodityDto.getItemListDtos();
            List<ItemListBean> items = new ArrayList<ItemListBean>();
            for (ItemListDto item : itemListDtos) {
                ItemListBean itemBean = this.convertItemList(item);
                items.add(itemBean);
            }
            bean.setItemListBeans(items);
        }
        if (null != commodityDto.getCommodityPropertyDtos()) {
            List<CommodityPropertyDto> commodityPropertyDtos = commodityDto.getCommodityPropertyDtos();
            List<CommodityPropertyBean> props = new ArrayList<CommodityPropertyBean>();
            for (CommodityPropertyDto prop : commodityPropertyDtos) {
                CommodityPropertyBean propBean = this.convertCommodityProperty(prop);
                props.add(propBean);
            }
            bean.setCommodityPropertyBeans(props);
        }
    }
}
