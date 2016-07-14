package org.zyd.web.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/encyclopedia")
public class EncyclopediaController {
	
	@RequestMapping("/index")
	public String index() {
		return "encyclopedia/index";
	}
	
}
