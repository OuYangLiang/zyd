package org.zyd.web.web.usercenter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user-center")
public class MainController {
	
	@RequestMapping("/index")
	public String index() {
		return "user-center/index";
	}
	
}
