package com.hk.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 钻石操作符(泛型)
 *
 * @author : kally
 * @date : 2018/5/27 21 16
 */
public class DiamondOperatorTest {

    public static void main(String[] args) {
        /*
            创建继承于 ArrayList的匿名子类对象
            在JDK 8 及之前不可以，JDK 9 中可以
          */

        List<String> list = new ArrayList<>() {


            /*
                构造代码块
                   创建对象自动添加元素
              */ {
                add("name");
            }
        };

        System.out.println(list);

    }
}
