package com.example.administrator.mycustomertest;

import android.util.Log;

/**
 * Created by Administrator on 2017/12/15.
 */

public class MapTest {

    public static void main(String[] agrs) {

        NewMap<String, String> myMap = new NewMap<>();
        myMap.put("1", "one");
        myMap.put("1", "two");
        myMap.put("3", "three");
        System.out.println(myMap.get("1"));
    }

}
