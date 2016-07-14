package org.zyd.web.security;

public class AsyncLoginRlt {
	private String status; //0失败，1成功，2需要登录
	private String errors;

	public AsyncLoginRlt(String status, String errors) {
		this.status = status;
		this.errors = errors;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}

}
