package org.zyd.web.util;

public class AsyncRlt {
    private boolean status;
    private String errors;
    private String code;

    public AsyncRlt(boolean status, String errors, String code) {
        this.status = status;
        this.errors = errors;
        this.code = code;
    }

    public AsyncRlt(boolean status, String errors) {
        this.status = status;
        this.errors = errors;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
