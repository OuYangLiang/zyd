package org.zyd.web.web;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zyd.common.constants.ContactType;
import org.zyd.common.exception.ZydException;
import org.zyd.service.dto.BoutiqueDto;
import org.zyd.service.dto.CommodityDto;
import org.zyd.service.dto.PurchaseOrderDto;
import org.zyd.service.dto.ShoppingCartItemDto;
import org.zyd.service.dto.TeaDto;
import org.zyd.service.dto.TeapotDto;
import org.zyd.service.inf.CommodityInf;
import org.zyd.service.inf.PartyInf;
import org.zyd.web.BaseController;
import org.zyd.web.constants.CommonConstants;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
    @Autowired
    private PartyInf partyInf;
    @Autowired
    private CommodityInf commodityInf;

    @RequestMapping("/preview")
    public String preview(Model model, HttpSession session, String cIds, RedirectAttributes attr) {
        try {
            if (StringUtils.isEmpty(cIds)) {
                attr.addAttribute("msg", URLEncoder.encode(new String("再这样把你加入黑名单了".getBytes("UTF-8")), "UTF-8"));
                return "redirect:/party/cart/index";
            }
            String[] ids = cIds.split(",");
            PurchaseOrderDto order = new PurchaseOrderDto();
            List<ShoppingCartItemDto> cartItems = new ArrayList<ShoppingCartItemDto>();
            int totalCount = 0;
            BigDecimal total = BigDecimal.ZERO;
            for (String id : ids) {
                ShoppingCartItemDto item = partyInf.queryShoppingCartItemDto(this.getPartyId(), new BigDecimal(id));
                if (item == null) {
                    continue;
                }
                CommodityDto cmmdty = commodityInf.queryCommodityByKey(item.getCmmdtyId());
                if (cmmdty == null) {
                    continue;
                }
                BigDecimal price = BigDecimal.ZERO;
                if (cmmdty instanceof TeapotDto) {
                    TeapotDto tpd = (TeapotDto) cmmdty;
                    price = tpd.getCurrentPrice();
                } else if (cmmdty instanceof BoutiqueDto) {
                    BoutiqueDto bd = (BoutiqueDto) cmmdty;
                    price = bd.getCurrentPrice();
                } else if (cmmdty instanceof TeaDto) {
                    TeaDto td = (TeaDto) cmmdty;
                    price = td.getCurrentPrice();
                }
                totalCount += item.getQtyToBuy();
                total = total.add(price.multiply(BigDecimal.valueOf(item.getQtyToBuy())));
                List<CommodityDto> gifts = commodityInf.queryGift(item.getCmmdtyId());
                cmmdty.setGifts(gifts);
                item.setCmmdty(cmmdty);
                cartItems.add(item);
            }

            if (CollectionUtils.isEmpty(cartItems)) {
                attr.addAttribute("msg", URLEncoder.encode(new String("东西不在喽，重试一下吧".getBytes("UTF-8")), "UTF-8"));
                return "redirect:/party/cart/index";
            }
            order.setOrderTotalPrice(total);
            order.setFreeLogisticsCondition(CommonConstants.FREE_LOGISTICS_CONDITION);
            order.setFreeLogisticsAmt(CommonConstants.FREE_LOGISTICS_CONDITION.compareTo(total) == -1);
            order.setTotalCount(totalCount);
            // TODO 物流费用
            order.setLogisticsAmt(order.isFreeLogisticsAmt() ? BigDecimal.ZERO : BigDecimal.valueOf(8));
            order.setOrderShouldPayment(order.getOrderTotalPrice().add(order.getLogisticsAmt()));
            //TODO 查询默认收货地址
            partyInf.queryPartyContactInfo(total, ContactType.A0600010);
            model.addAttribute("order", order);
            model.addAttribute("orderItems", cartItems);
        } catch (ZydException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "order/preview";
    }
}
