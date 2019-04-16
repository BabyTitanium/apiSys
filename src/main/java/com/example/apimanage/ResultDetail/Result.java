package com.example.apimanage.ResultDetail;

import java.util.HashMap;
import java.util.Map;

public class Result {
    public static Map<String,Object> successResult(Map<String,Object> data,String message){
        Map<String,Object> map=new HashMap<>();
        map.put("data",data);
        map.put("status","success");
        map.put("message",message);
        return map;
    }
    public static Map<String,Object> successResult(Map<String,Object> data){
        Map<String,Object> map=new HashMap<>();
        map.put("data",data);
        map.put("status","success");
        map.put("message","");
        return map;
    }
    public static Map<String,Object> successResult(){
        Map<String,Object> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
    public static Map<String,Object> successResult(String message){
        Map<String,Object> map=new HashMap<>();
        map.put("status","success");
        map.put("message",message);
        return map;
    }
    public static Map<String,Object> errorResult(String message){
        Map<String,Object> map=new HashMap<>();
        map.put("status","error");
        map.put("message",message);
        return map;

    }
}
