package com.example.apimanage.utils;

import com.example.apimanage.ResultDetail.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String, Object> jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        return Result.errorResult(e.getMessage());
    }
}
