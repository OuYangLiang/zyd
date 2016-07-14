package org.zyd.web.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zyd.common.exception.ZydException;
import org.zyd.common.util.Validator;
import org.zyd.service.dto.PartyAccountDto;
import org.zyd.service.inf.PartyInf;
import org.zyd.web.util.AsyncRlt;

@Controller
public class RegisterController {
	@Autowired
	private PartyInf partyInf;
	
	@RequestMapping("/register")
	public String register() {
		return "login/register";
	}
	
	@RequestMapping("/register/async/account/verify")
	@ResponseBody
	public AsyncRlt checkAccount(@RequestParam(value = "acnt", required = false) String acnt, 
								@RequestParam(value = "vcode", required = false) String vcode) throws ZydException {
		
		if (null == acnt || acnt.trim().isEmpty()) {
			return new AsyncRlt(false, "请输入注册手机");
		}
		
		if (null == vcode || vcode.trim().isEmpty()) {
			return new AsyncRlt(false, "请输入手机验证码");
		}
		
		if (!Validator.isMobile(acnt.trim())) {
			return new AsyncRlt(false, "请输入合法的手机号码");
		}
		
		PartyAccountDto account = partyInf.queryPartyAccountDto(acnt);
		
		if (null != account) {
			return new AsyncRlt(false, "手机号码已经注册，请更换手机号");
		}
		
		if (!"0000".equalsIgnoreCase(vcode)) {
			return new AsyncRlt(false, "手机验证码不正确");
		}
		
		return new AsyncRlt(true, null);
	}
	
	@RequestMapping("/register/save")
	@ResponseBody
	public AsyncRlt save(@RequestParam(value = "acnt", required = false) String acnt,
						@RequestParam(value = "vcode", required = false) String vcode,
						@RequestParam(value = "pwd", required = false) String pwd) throws ZydException {
		
		if (null == acnt || acnt.trim().isEmpty()) {
			return new AsyncRlt(false, "请输入注册手机");
		}
		
		if (null == vcode || vcode.trim().isEmpty()) {
			return new AsyncRlt(false, "请输入手机验证码");
		}
		
		if (!Validator.isMobile(acnt.trim())) {
			return new AsyncRlt(false, "请输入合法的手机号码");
		}
		
		if (!"0000".equalsIgnoreCase(vcode)) {
			return new AsyncRlt(false, "手机验证码不正确");
		}
		
		try {
			partyInf.createParty(acnt, pwd, null);
		} catch (ZydException e) {
			return new AsyncRlt(false, e.getErrorCode().getDesc());
		}
		
		return new AsyncRlt(true, null);
	}
}
