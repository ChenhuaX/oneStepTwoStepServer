package com.chx.config;

import com.alibaba.fastjson2.JSON;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

// 通用全局异常管理模块
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CommonGlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String commonExceptionHandler(HttpServletRequest request, Exception e){
        String errorMsg = e.getMessage();
        //定制状态码
        // 判断异常类型，如果属于ConditionException，做特殊处理
        if(e instanceof ConditionException){
            String errorCode = ((ConditionException) e).getCode();
            return JSON.toJSONString(new JsonResponse<>(errorCode, errorMsg));
        }else{
            return JSON.toJSONString(new JsonResponse<>("500", errorMsg));
        }
    }
}
