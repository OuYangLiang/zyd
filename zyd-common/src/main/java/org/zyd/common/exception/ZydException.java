package org.zyd.common.exception;

import org.zyd.common.constants.ErrorCode;

public class ZydException extends Exception {
	private static final long serialVersionUID = -5712898389776298613L;

	private ErrorCode errorCode;

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public ZydException(ErrorCode errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public ZydException(ErrorCode errorCode, String s, Throwable t) {
		super(s, t);
		this.errorCode = errorCode;
	}

	public ZydException(ErrorCode errorCode, String s) {
		super(s);
		this.errorCode = errorCode;
	}

	public ZydException(ErrorCode errorCode, Throwable t) {
		super(t);
		this.errorCode = errorCode;
	}
}
