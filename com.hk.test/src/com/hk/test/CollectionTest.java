package com.hk.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 集合增强
 * @author : kally
 * @date : 2018/5/26 23 08
 */
public class CollectionTest {

    public static void main(String[] args) {
        //JDK 8 及之前，创建一个只读集合
        List<String> list = new ArrayList<>();
        list.add("MM");
        list.add("JJ");
        list.add("DD");
        list = Collections.unmodifiableList(list);
        list.forEach(System.out::println);
//        list.add("GG");// 不能再添加，会抛出异常


        /*
         JDK 9 中，可以直接使用of 方法
           同时，Set 、Map 也添加了 of方法
           Map 还添加了 ofEntries方法
          */

        List<Integer> integerList = List.of(1, 2, 3);
//        integerList.add(5);抛出异常.
        integerList.forEach(System.out::println);
    }
}
