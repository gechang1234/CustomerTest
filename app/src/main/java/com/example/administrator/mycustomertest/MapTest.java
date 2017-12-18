package com.example.administrator.mycustomertest;

import android.util.Log;

/**
 * Created by Administrator on 2017/12/15.
 */

public class MapTest {

    public static void main(String[] agrs) {

        NewMap<String, String> myMap = new NewMap<>();
        myMap.put("1", "one");
        myMap.put("2", "two");
        myMap.put("3", "three");
        NewMap<String, String> mymap2 = new NewMap<>();
        mymap2.putAll(myMap);
        mymap2.values();
        mymap2.entrySet();
        mymap2.keySet();
        System.out.println(mymap2.get("1"));
        System.out.println(mymap2.get("2"));
        System.out.println(mymap2.get("3"));
    }

}
