package com.weibo.exception;

import com.weibo.enums.ResultEnum;

//抛出RuntimeException后才会进行事务回滚，而抛出Exception不会进行回滚
//因为Exception类只能传递一个message参数，如果需要传递多个错误参数的话，就用到这里新的异常类
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public GirlException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
