package com.example.administrator.mycustomertest;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/15.
 */

public class LinkTest {

    public static void main(String[] args) {
        NewList linked = new NewList();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(3, 5);
        linked.contains(4);
        linked.remove(1);
        linked.out();
        linked.clear();
        linked.out();
        System.out.println(linked.size());
    }
}

