package com.hk.test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * try 语句增强
 *
 * @author : kally
 * @date : 2018/5/26 22 50
 */
public class TryTest {

    public static void main(String[] args) {

        jdk7AndBefore();


        jdk8();

        jdk9();


    }

    /**
     * <p>
     * jdk 7 及之前
     *
     * </p>
     * <p>
     * try 后面不能使用小括号
     *
     * </p>
     */
    private static void jdk7AndBefore() {
        InputStreamReader reader = new InputStreamReader(System.in);
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        try {
            reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != writer) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * <p>
     * jdk 9 中
     *
     * </p>
     * <p>
     * try 后面如果有多个需要关闭的资源，可以使用英文分号隔开，
     *  不需要写 finally 块，会自动关闭流
     * </p>
     */
    public static void jdk9() {
        InputStreamReader reader = new InputStreamReader(System.in);
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        try (reader; writer) {
//            reader = null; reader 和 writer 都会提升为final类型，不能再次修改
            reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        finally {
//            if(null != reader){
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            if(null != writer){
//                try {
//                    writer.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

    }

    /**
     * <p>
     * jdk 8 语法
     *
     * </p>
     * <p>
     *     try 后面只能有一个需要关闭的资源，可以使用英文分号隔开，
     *     不需要写 finally 块，会自动关闭流
     *
     * </p>
     */
    public static void jdk8() {
        //在 try后面括号中的资源，不需要使用finally 片段来关闭资源，会自动关闭
        try (InputStreamReader reader = new InputStreamReader(System.in)) {
//            reader = null; reader 会提升为final类型，不能再次修改
            reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        finally {
//            if(null != reader){
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            if(null != writer){
//                try {
//                    writer.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }
}
