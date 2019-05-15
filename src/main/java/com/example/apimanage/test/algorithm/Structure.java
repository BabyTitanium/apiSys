package com.example.apimanage.test.algorithm;


import com.example.apimanage.domain.dto.User;
import com.sun.org.apache.bcel.internal.generic.LUSHR;
import io.swagger.models.auth.In;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

public class Structure {
    static  Hashtable<String,String> hashtable=new Hashtable<String,String>();
    static ArrayList<String> list=new ArrayList<>();

    static class Thread1 implements Runnable{
        @Override
        public void run() {
            hashtable.put("1","111");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String s=hashtable.get("1");
            System.out.println(s);
        }
    }
    static class Thread2 implements Runnable{
        @Override
        public void run() {
            String str=hashtable.get("1");
            System.out.println(str);
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
       Fan<String> stringFan=new Fan<>();
       stringFan.setName("刘");
        List<String> list1=new ArrayList<>();
        list1.add("111");
        list1.add("222");
        Tong tong=new Tong();
        tong.setList(list1);
        List<String> list2= (List<String>) tong.getList();
        list2.forEach(l-> System.out.println(l));
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime);
    }
    public  String getName(){
       String s=null;
       return Optional.ofNullable(s)
               .map(name->s)
               .orElse("呜呜呜");
    }
    public  String getName(String a){
        return a;
    }

}
