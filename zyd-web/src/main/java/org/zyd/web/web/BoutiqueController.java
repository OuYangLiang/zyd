package org.zyd.web.web;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/boutique")
public class BoutiqueController {
	
	@RequestMapping("/list")
	public String index() {
		return "boutique/list";
	}
	
	@RequestMapping("/{cmmdtyId}/view")
	public String view(@PathVariable BigDecimal cmmdtyId) {
		return "boutique/view";
	}
	
}
