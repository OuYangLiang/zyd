package org.zyd.web.web;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zyd.common.constants.AccountType;
import org.zyd.common.constants.Category;
import org.zyd.common.constants.CommodityImageType;
import org.zyd.common.constants.CommoditySortCriteria;
import org.zyd.common.constants.EvaluationLevel;
import org.zyd.common.constants.TeapotLevel;
import org.zyd.common.constants.TeapotMaterial;
import org.zyd.common.constants.TeapotPriceRegion;
import org.zyd.common.constants.TeapotShape;
import org.zyd.common.constants.TeapotType;
import org.zyd.common.exception.ZydException;
import org.zyd.common.vo.TeapotSearchVo;
import org.zyd.service.dto.AddedEvaluationDto;
import org.zyd.service.dto.CommodityDto;
import org.zyd.service.dto.CommodityEnquiringDto;
import org.zyd.service.dto.CommodityEvaluationDto;
import org.zyd.service.dto.CommodityImageDto;
import org.zyd.service.dto.CommodityPropertyDto;
import org.zyd.service.dto.EvaluationImageDto;
import org.zyd.service.dto.EvaluationLabelDto;
import org.zyd.service.dto.PartyAccountDto;
import org.zyd.service.dto.PartyLevelDto;
import org.zyd.service.dto.TeapotDto;
import org.zyd.service.inf.CommodityInf;
import org.zyd.service.inf.EvaluationInf;
import org.zyd.service.inf.PartyInf;
import org.zyd.web.constants.CommonConstants;

@Controller
@RequestMapping("/teapot")
public class TeapotController {
    @Autowired
    private CommodityInf commodityInf;
    @Autowired
    private EvaluationInf evaluationInf;
    @Autowired
    private PartyInf partyInf;

    @RequestMapping("/list")
    public String index(Model model, HttpSession session, String s, Integer p, String sort) {
        TeapotSearchVo queryParam = new TeapotSearchVo();
        queryParam.setCategory(Category.A2100010.name());
        try {
            if (null == p || p == 0) {
                p = 1;
            }
            this.toQueryParam(queryParam, s);
            CommoditySortCriteria cur = this.toSortEnum(sort);

            int count = commodityInf.queryCountOfTeapots(queryParam);
            List<TeapotDto> teapots = commodityInf.queryTeapots(queryParam, cur, CommonConstants.SEARCH_PAGE_SIZE, p);

            Map<String, String> types = TeapotType.toMaps();
            Map<String, String> shapes = this.getShapeMaps(queryParam);
            Map<String, String> materials = TeapotMaterial.toMaps();
            Map<String, String> levels = TeapotLevel.toMaps();
            Map<String, String> priceRegions = TeapotPriceRegion.toMaps();

            model.addAttribute("types", types);
            model.addAttribute("shapes", shapes);
            model.addAttribute("materials", materials);
            model.addAttribute("levels", levels);
            model.addAttribute("priceRegions", priceRegions);
            model.addAttribute("count", count);
            model.addAttribute("pageCount", count % 20 == 0 ? count / 20 : count / 20 + 1);
            model.addAttribute("sort", cur);
            model.addAttribute("queryParam", queryParam);
            model.addAttribute("list", teapots);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "teapot/list";
    }

    @RequestMapping("/{cmmdtyId}/view")
    public String view(@PathVariable BigDecimal cmmdtyId, Model model) {
        try {
            TeapotDto teapot = commodityInf.queryTeapotByKey(cmmdtyId);
            List<CommodityDto> gifts = commodityInf.queryGift(cmmdtyId);
            List<CommodityDto> recommends = commodityInf.queryRecommended(cmmdtyId);
            List<CommodityPropertyDto> properties = commodityInf.queryCommodityProperties(cmmdtyId);

            List<CommodityImageDto> detailImages = commodityInf.queryCommodityImages(cmmdtyId,
                    CommodityImageType.A5800040);

            teapot.setEffective(isEffective(teapot.getUnshelvesTime(), teapot.getNumStored()));
            model.addAttribute("gifts", gifts);
            model.addAttribute("recommends", recommends);
            model.addAttribute("properties", properties);
            model.addAttribute("detailImages", detailImages);
            model.addAttribute("teapot", teapot);
        } catch (ZydException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "teapot/view";
    }

    @RequestMapping("/async/{cmmdtyId}/evaluations/num")
    public String numOfEvaluations(Model model, @PathVariable BigDecimal cmmdtyId) {
        try {
            List<EvaluationLabelDto> evalLabels = evaluationInf.queryEvaluationLabelsByCommodity(cmmdtyId);

            int imagedCount = evaluationInf.queryCountOfImagedEvaluations(cmmdtyId);
            int addedCount = evaluationInf.queryCountOfEvaluationsWithAddedEvaluations(cmmdtyId);
            int gCount = evaluationInf.queryCountOfEvaluationsByLevel(cmmdtyId, EvaluationLevel.A3100010);
            int mCount = evaluationInf.queryCountOfEvaluationsByLevel(cmmdtyId, EvaluationLevel.A3100020);
            int pCount = evaluationInf.queryCountOfEvaluationsByLevel(cmmdtyId, EvaluationLevel.A3100030);

            model.addAttribute("evalLabels", evalLabels);
            model.addAttribute("imagedCount", imagedCount);
            model.addAttribute("addedCount", addedCount);
            model.addAttribute("gCount", gCount);
            model.addAttribute("mCount", mCount);
            model.addAttribute("pCount", pCount);
        } catch (ZydException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "teapot/evaluation";
    }

    @RequestMapping("/async/{cmmdtyId}/evaluations")
    @ResponseBody
    public Map<String, Object> queryEvals(Model model, @PathVariable BigDecimal cmmdtyId, String m, Integer p) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if (null == p || p == 0) {
                p = 1;
            }
            List<CommodityEvaluationDto> evals = null;
            if (StringUtils.isEmpty(m) || "1".equals(m)) {
                evals = evaluationInf.queryEvaluationsByCommodity(cmmdtyId, CommonConstants.SEARCH_PAGE_SIZE, p);
            } else if ("2".equals(m)) {
                evals = evaluationInf.queryImagedEvaluations(cmmdtyId, CommonConstants.SEARCH_PAGE_SIZE, p);
            } else if ("3".equals(m)) {
                evals = evaluationInf.queryEvaluationsByLevel(cmmdtyId, EvaluationLevel.A3100010,
                        CommonConstants.SEARCH_PAGE_SIZE, p);
            } else if ("4".equals(m)) {
                evals = evaluationInf.queryEvaluationsByLevel(cmmdtyId, EvaluationLevel.A3100020,
                        CommonConstants.SEARCH_PAGE_SIZE, p);
            } else if ("5".equals(m)) {
                evals = evaluationInf.queryEvaluationsByLevel(cmmdtyId, EvaluationLevel.A3100030,
                        CommonConstants.SEARCH_PAGE_SIZE, p);
            } else if ("6".equals(m)) {
                evals = evaluationInf.queryEvaluationsWithAddedEvaluations(cmmdtyId, CommonConstants.SEARCH_PAGE_SIZE,
                        p);
            }

            map.put("evals", evals);
        } catch (ZydException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return map;
    }

    @RequestMapping("/async/evaluations")
    @ResponseBody
    public Map<String, Object> evaluations(Model model, BigDecimal evalId, BigDecimal partyId, Boolean imaged,
            Boolean addedEval) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            PartyAccountDto partyAccount = partyInf.queryPartyAccountDto(partyId, AccountType.A0800010);
            PartyLevelDto partyLevel = partyInf.queryPartyLevel(partyId);
            partyAccount.setAcntVal(partyAccount.getAcntVal().replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2"));
            partyAccount.setLevel(partyLevel.getLevel().getDesc());
            map.put("partyAccount", partyAccount);

            if (null != imaged && imaged) {
                List<EvaluationImageDto> evalImgs = evaluationInf.queryImagesByEvaluation(evalId);
                if (!CollectionUtils.isEmpty(evalImgs)) {
                    map.put("evalImgs", evalImgs);
                }
            }
            if (null != addedEval && addedEval) {
                List<AddedEvaluationDto> addedEvals = evaluationInf.queryAddedEvaluations(evalId);
                if (!CollectionUtils.isEmpty(addedEvals)) {
                    map.put("addedEvals", addedEvals);
                }
            }
        } catch (ZydException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("/async/{cmmdtyId}/enquirings")
    public String enquirings(Model model, @PathVariable BigDecimal cmmdtyId, Integer p) {
        try {
            if (null == p || p == 0) {
                p = 1;
            }
            List<CommodityEnquiringDto> enquirings = commodityInf.queryCommodityEnquiringsByCommodity(cmmdtyId,
                    CommonConstants.SEARCH_PAGE_SIZE, p);

            model.addAttribute("enquirings", enquirings);
        } catch (ZydException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "teapot/enquiring";
    }

    private CommoditySortCriteria toSortEnum(String sort) {
        CommoditySortCriteria s = CommoditySortCriteria.default_sort;
        if ("default".equalsIgnoreCase(sort)) {
            s = CommoditySortCriteria.default_sort;
        } else if ("sales".equalsIgnoreCase(sort)) {
            s = CommoditySortCriteria.sales_desc;
        } else if ("eval".equalsIgnoreCase(sort)) {
            s = CommoditySortCriteria.evaluated_desc;
        } else if ("price_d".equalsIgnoreCase(sort)) {
            s = CommoditySortCriteria.price_desc;
        } else if ("price_a".equalsIgnoreCase(sort)) {
            s = CommoditySortCriteria.price_asc;
        }
        return s;
    }

    private void toQueryParam(TeapotSearchVo queryParam, String s) {
        if (StringUtils.isEmpty(s) || !s.contains(":")) {
            return;
        }
        if (s.contains(",")) {
            String[] params = s.split(",");
            for (String param : params) {
                eachQueryParam(queryParam, param);
            }
        } else {
            eachQueryParam(queryParam, s);
        }

    }

    private void eachQueryParam(TeapotSearchVo queryParam, String s) {
        if (StringUtils.isEmpty(s) || !s.contains(":")) {
            return;
        }
        String[] ps = s.split(":");
        if (ps.length != 2) {
            return;
        }
        try {
            if ("235".equals(ps[0])) {
                queryParam.setType(TeapotType.valueOf(ps[1]).name());
                queryParam.setShape(null);
            } else if ("240".equals(ps[0])) {
                queryParam.setShape(TeapotShape.valueOf(ps[1]).name());
            } else if ("250".equals(ps[0])) {
                queryParam.setMaterial(TeapotMaterial.valueOf(ps[1]).name());
            } else if ("430".equals(ps[0])) {
                queryParam.setLevel(TeapotLevel.valueOf(ps[1]).name());
            } else if ("220".equals(ps[0])) {
                queryParam.setPriceRegion(TeapotPriceRegion.valueOf(ps[1]).name());
            }
        } catch (Exception e) {
            return;
        }
    }

    private Map<String, String> getShapeMaps(TeapotSearchVo queryParam) {
        if (StringUtils.isEmpty(queryParam.getType())) {
            return TeapotShape.toMaps();
        }
        if (queryParam.getType().equalsIgnoreCase("A2350010")) {
            return TeapotShape.to240Maps();
        } else if (queryParam.getType().equalsIgnoreCase("A2350020")) {
            return TeapotShape.to241Maps();
        } else if (queryParam.getType().equalsIgnoreCase("A2350030")) {
            return TeapotShape.to242Maps();
        } else if (queryParam.getType().equalsIgnoreCase("A2350040")) {
            return TeapotShape.to243Maps();
        }
        return TeapotShape.toMaps();
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
