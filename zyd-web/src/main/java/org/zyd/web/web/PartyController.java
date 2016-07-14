package org.zyd.web.web;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zyd.common.exception.ZydException;
import org.zyd.service.dto.BoutiqueDto;
import org.zyd.service.dto.CommodityDto;
import org.zyd.service.dto.ShoppingCartDto;
import org.zyd.service.dto.ShoppingCartItemDto;
import org.zyd.service.dto.TeaDto;
import org.zyd.service.dto.TeapotDto;
import org.zyd.service.inf.CommodityInf;
import org.zyd.service.inf.PartyInf;
import org.zyd.web.BaseController;
import org.zyd.web.util.AsyncRlt;

@Controller
@RequestMapping("/party")
public class PartyController extends BaseController {
    @Autowired
    private PartyInf partyInf;
    @Autowired
    private CommodityInf commodityInf;

    @RequestMapping("/list")
    public String index() {
        return "tea/list";
    }

    @RequestMapping("/async/cart/add")
    @ResponseBody
    public AsyncRlt addCmmdtyToCart(HttpSession session, BigDecimal cmmdtyId, int qty) {
        try {
            partyInf.addCommodityToShoppingCart(this.getPartyId(), cmmdtyId, qty);
        } catch (ZydException e) {
            e.getErrorCode().getDesc();
            return new AsyncRlt(false, "小巅开小差了，请稍后找他~", null);
        }
        return new AsyncRlt(true, null, null);
    }

    @RequestMapping("/cart/index")
    public String toDisplyCart(Model model, String msg) {
        try {
            if (!StringUtils.isEmpty(msg)) {
                model.addAttribute("msg", URLDecoder.decode(msg, "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "cart/list";
    }

    @RequestMapping("/async/cart/list")
    @ResponseBody
    public ShoppingCartDto cartList(HttpSession session) {
        try {
            ShoppingCartDto cart = partyInf.queryShoppingCartDto(this.getPartyId());
            if (null == cart) {
                return null;
            }
            List<ShoppingCartItemDto> items = cart.getItems();
            if (CollectionUtils.isEmpty(items)) {
                return null;
            }
            List<ShoppingCartItemDto> uneffective = new ArrayList<ShoppingCartItemDto>();
            for (ShoppingCartItemDto dto : items) {
                CommodityDto cmmdty = commodityInf.queryCommodityByKey(dto.getCmmdtyId());
                // TODO if cmmdty == null 可能因为放入购物车的商品已被删除或下架，此时考虑怎么做，是直接过滤，还是标记成失效
                Boolean effective = false;
                if (cmmdty instanceof TeapotDto) {
                    TeapotDto tpd = (TeapotDto) cmmdty;
                    effective = isEffective(tpd.getUnshelvesTime(), tpd.getNumStored());
                } else if (cmmdty instanceof BoutiqueDto) {
                    BoutiqueDto bd = (BoutiqueDto) cmmdty;
                    effective = isEffective(bd.getUnshelvesTime(), bd.getNumStored());
                } else if (cmmdty instanceof TeaDto) {
                    TeaDto td = (TeaDto) cmmdty;
                    effective = isEffective(td.getUnshelvesTime(), td.getNumStored());
                }
                cmmdty.setEffective(effective);
                dto.setCmmdty(cmmdty);
                if (!effective) {
                    uneffective.add(dto);
                }
            }
            items.removeAll(uneffective);
            items.addAll(uneffective);
            return cart;
        } catch (ZydException e) {
            e.getErrorCode().getDesc();
        }
        return null;
    }

    @RequestMapping("/async/cart/delCmmdty")
    @ResponseBody
    public AsyncRlt delCmmdty(HttpSession session, BigDecimal cmmdtyId) {
        try {
            if (null == cmmdtyId) {
                return new AsyncRlt(false, "请求URL异常");
            }
            partyInf.removeCommodityFromShoppingCart(this.getPartyId(), cmmdtyId);

            return new AsyncRlt(true, null);
        } catch (ZydException e) {
            e.printStackTrace();
            return new AsyncRlt(false, e.getErrorCode().getDesc());
        }
    }

    @RequestMapping("/async/cart/batchDel")
    @ResponseBody
    public AsyncRlt batchDel(HttpSession session, String cmmdtyIds) {
        try {
            if (StringUtils.isEmpty(cmmdtyIds)) {
                return new AsyncRlt(false, "别逗了，根本就没选好不好");
            }
            String[] cids = cmmdtyIds.split(",");
            for (String id : cids) {
                partyInf.removeCommodityFromShoppingCart(this.getPartyId(), new BigDecimal(id));
            }
            return new AsyncRlt(true, null);
        } catch (ZydException e) {
            e.printStackTrace();
            return new AsyncRlt(false, e.getErrorCode().getDesc());
        }
    }

    @RequestMapping("/async/cart/clear")
    @ResponseBody
    public AsyncRlt clear(HttpSession session) {
        try {
            partyInf.cleanShoppingCart(this.getPartyId());

            return new AsyncRlt(true, null);
        } catch (ZydException e) {
            e.printStackTrace();
            return new AsyncRlt(false, e.getErrorCode().getDesc());
        }
    }

    @RequestMapping("/async/cart/change")
    @ResponseBody
    public AsyncRlt changeNum(HttpSession session, BigDecimal cmmdtyId, Integer qty) {
        try {
            partyInf.changeCommodityQtyFromShoppingCart(this.getPartyId(), cmmdtyId, qty);

            return new AsyncRlt(true, null);
        } catch (ZydException e) {
            e.printStackTrace();
            return new AsyncRlt(false, e.getErrorCode().getDesc());
        }
    }

    private boolean isEffective(Date unshelvesTime, Integer numStored) {
        if (unshelvesTime != null && unshelvesTime.getTime() < (new Date()).getTime()) {
            return false;
        }
        if (numStored <= 0) {
            return false;
        }
        return true;
    }

}
