package com.hk.test;

import java.util.stream.Stream;

/**
 * Stream 增强
 * @author : kally
 * @date : 2018/5/27 08 31
 */
public class StreamTest {

    public static void main(String[] args) {
        takeWhile();
        System.out.println();
        dropWhile();

        System.out.println();
        ofNullable();

        System.out.println();
        iterator();
    }

    /**
     * takeWhile
     */
    public static void takeWhile() {
        Stream<Integer> stream = Stream.of(2, 34, 56, 23, 12, 44, 63, 745);
        //从头开始，只要迭代的元素小于50就不再迭代，返回已迭代的元素 // 如只返回  2 和 34
        stream.takeWhile(x -> x < 50).forEach(System.out::println);
    }

    /**
     * dropWhile
     */
    public static void dropWhile() {
        Stream<Integer> stream = Stream.of(2, 34, 56, 23, 12, 44, 63, 745);
        //和 takeWhile相反，从头开始，只要迭代的元素小于50都不要，返回未迭代的元素 // 如只返回 56, 23, 12, 44, 63, 745
        stream.dropWhile(x -> x < 50).forEach(System.out::println);
    }

    /**
     * ofNullable
     */
    public static void ofNullable() {
        //对于只有单个元素的 Stream，如果这个元素为 null，会抛出 NullPointerException.
//        Stream<Object> stream = Stream.of(null);
//        System.out.println(stream.count());

        // 如果有多个元素，即使存在空元素，也不会抛出 NullPointerException
        Stream.of(3, 5, null).forEach(System.out::println);

        System.out.println();

        //如果只有单个元素，可以使用 ofNullable 方法
        Stream<Object> stream = Stream.ofNullable(null);
        System.out.println(stream.count());
    }

    public static void iterator() {
        //在jdk 8 中，使用 iterate 方法创建的Stream ，要使用 Limit 方法限制产生的元素个数
        Stream.iterate(0, x -> x + 1).limit(10).forEach(System.out::println);

        System.out.println();

        // 在JDK 9 中，可以使用iterate 的重载方法，接受一个 Predicate 参数，达到指定条件就不再产生元素。
        Stream.iterate(0, x -> x < 10, x -> x + 1).forEach(System.out::println);
    }
}
