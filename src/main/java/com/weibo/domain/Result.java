package com.weibo.domain;

/**
 * http请求返回最外层对象
 * 通过这个对象，实现数据封装和格式统一，实现统一异常处理
 * 不论程序执行对错，都可以用这个类返回相同格式的结果给下游程序处理
 */
public class Result<T> {

    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String message;

    /**  具体内容 */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
