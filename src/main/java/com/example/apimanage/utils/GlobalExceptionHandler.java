package com.example.apimanage.utils;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String, Object> allHandler(HttpServletRequest req, Exception e) throws Exception {
        return Result.errorResult("未知错误",e.getMessage());
    }

    @ExceptionHandler({MissingServletRequestParameterException.class, TypeMismatchException.class})
    @ResponseBody
    public Map<String, Object> paramErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        System.out.println(e.getClass());

        return Result.errorResult("参数错误", e.getMessage());
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public Map<String, Object> requestErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        System.out.println(e.getClass());

        return Result.errorResult("请求错误", e.getMessage());
    }
}
