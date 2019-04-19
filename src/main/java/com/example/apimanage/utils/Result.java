package com.example.apimanage.utils;

import java.util.HashMap;
import java.util.Map;

public class Result {
    public static <T> Map<String,Object> successResult(T t, String message){
        Map<String,Object> map=new HashMap<>();
        map.put("data",t);
        map.put("status","success");
        map.put("message",message);
        return map;
    }

    public static <T> Map<String,Object> successResult(T t){
        Map<String,Object> map=new HashMap<>();
        map.put("data",t);
        map.put("status","success");
        map.put("message","成功");
        return map;
    }

    public static Map<String,Object> errorResult(String message){
        Map<String,Object> map=new HashMap<>();
        map.put("status","error");
        map.put("message",message);
        map.put("data","");
        return map;

    }

    public static <T> Map<String,Object> errorResult(String message, T t){
        Map<String,Object> map=new HashMap<>();
        map.put("status","error");
        map.put("message",message);
        map.put("data", t);
        return map;
    }

}
