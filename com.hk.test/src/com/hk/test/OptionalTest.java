package com.hk.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Otpional添加转换为Stream 的方法
 * @author : kally
 * @date : 2018/5/27 09 27
 */
public class OptionalTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("MM");
        list.add("JJ");
        list.add("GG");
        Optional<List<String>> optionalStrings = Optional.of(list);

        //只有一个元素，这个元素是 list
        optionalStrings.ifPresent(System.out::println);

        // 如果要获取 list 中的每个元素，可以使用 flatMap
        Stream<String> stringStream = optionalStrings.stream().flatMap(Collection::stream);
        stringStream.forEach(System.out::println);
    }
}
