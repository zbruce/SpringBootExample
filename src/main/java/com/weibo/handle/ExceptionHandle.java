package com.weibo.handle;

import com.weibo.domain.Result;
import com.weibo.exception.GirlException;
import com.weibo.utility.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class) //声明要捕获的异常类
    @ResponseBody //要返回给浏览器json，而类没有注解restcontroller，因此这里加responsebody注解
    public Result handle(Exception e){
        if(e instanceof GirlException){ //建议定义自己的异常，便于与系统异常区分管理
            GirlException girlException = (GirlException)e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        }else{
            logger.error("[system exception] {}", e);
            return ResultUtil.error(-1, e.getMessage());
        }
    }
}
