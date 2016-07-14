package org.zyd.web.web.usercenter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user-center")
public class PurchaseOrderController {

	@RequestMapping("/purchaseOrder/index")
	public String index() {
		return "user-center/purchaseOrder/index";
	}
	
}
