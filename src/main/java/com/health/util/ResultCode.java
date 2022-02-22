package com.health.util;

public enum ResultCode {

    SUCCESS_CODE("200","交易成功"),
    ERROR_CODE("500","交易失败");

    private String code;

    private String msg;




    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
