package com.example.apimanage.test.algorithm;


import io.swagger.models.auth.In;

import java.util.*;

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

    public static void main(String[] args) {
        Thread1 thread1=new Thread1();
        Thread threadA=new Thread(thread1);
        Thread2 thread2=new Thread2();
        Thread threadB=new Thread(thread2);

        threadA.start(); threadB.start();
        list.add("你好");
        list.add("我是");
        Iterator<String> iterator=list.iterator();
        while (iterator.hasNext()){
            String s=iterator.next();
            System.out.println(s);
        }
    }

}
