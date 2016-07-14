package org.zyd.web.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String index(@RequestParam(value = "curl", required = false) String curl, Model model) {
		
		if (null != curl && !curl.isEmpty()) {
			model.addAttribute("curl", "?curl=" + curl);
		}
		
		return "login/index";
	}
	
	@RequestMapping("/test")
	public String indexes() throws Exception {
		return "test";
	}
	
}
