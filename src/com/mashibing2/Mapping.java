package com.mashibing2;

import java.util.HashMap;
import java.util.Map;

public class Mapping {

   private static  Map<String,String> map=new HashMap<String,String>();
    static {map.put("/mytomcat","com.mashibing2.serverlet"); }
    public static Map<String,String> getMap(){
        return map;
    }
}
