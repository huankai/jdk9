package com.hk.test;

/**
 * 接口增强
 * @author : kally
 * @date : 2018/5/26 22 12
 */
interface MyInterface {

    /**
     * 定义私有方法
     */
    private void privateMethod(){
        System.out.println("我是私有方法");
    }

    static void staticMethod(){
        System.out.println("我是静态方法");
    }

    default void defaultMethod(){
        privateMethod();
        System.out.println("我是默认方法");
    }

    void method();
}

public class MyInterfaceTest {

    public static void main(String[] args) {
        MyInterface myInterface = new MyInterface(){


            @Override
            public void method() {
                defaultMethod();
            }

            /**
             * 重写默认方法，如果要调用父类的默认方法，需要使用类名.super.默认方法名() 来调用
             * 不能直接使用super.默认方法名() 来调用
             */
            @Override
            public void defaultMethod() {
                MyInterface.super.defaultMethod();
            }
        };
        myInterface.method();

    }
}
