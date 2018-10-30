package com.weibo.enums;

//采用枚举的方式维护错误码和错误信息
public enum ResultEnum {
    UNKNOWN_ERROR(-1, "unknown error"),
    SUCCESS(0, "success"),
    PRIMARY_SCHOOL(100, "primary school"),
    MIDDLE_SCHOOL(101, "middle school")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
