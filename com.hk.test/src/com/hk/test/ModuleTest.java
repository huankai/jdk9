package com.hk.test;

import com.hk.address.Address;
import com.hk.user.User;

import java.util.List;

/**
 * @author : kally
 * @date : 2018/5/27 20 55
 */
public class ModuleTest {

    public static void main(String[] args) {
        User user = new User("1","zhangsang",null);
        System.out.println(user);

        /*
        使用 Address,必须在 module-info 中 requires com.hk.address
            或者在 com.hk.user模块中的 module-info.java 文件中 使用
         */
        user = new User("2","lisi",List.of(new Address("1","gz")));
        System.out.println(user);
    }
}
