package com.health.util;

public class CommResult<T> {

    private String code;

    private String msg;

    private T data;


    public CommResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> CommResult<T> success(T data, String message) {

        return new CommResult<T>(ResultCode.SUCCESS_CODE.getCode(), message, data);
    }

    public static <T> CommResult<T> success(T data) {

        return new CommResult<T>(ResultCode.SUCCESS_CODE.getCode(), ResultCode.SUCCESS_CODE.getMsg(), data);
    }

    public static <T> CommResult<T> error(T data){

        return new CommResult<T>(ResultCode.ERROR_CODE.getCode(), ResultCode.ERROR_CODE.getMsg(), data);
    }

    /**
     *    失败返回结果
     * @param data  数据
     * @param message 返回状态码
     * @return
     */
    public static <T> CommResult<T> error(T data, String message){

        return new CommResult<T>(ResultCode.ERROR_CODE.getCode(), message, data);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
