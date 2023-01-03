package com.xcode.icu.exam;

public class Test {


    public static void main(String args[]) {
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();
        MyThread mt3 = new MyThread();
        new Thread(mt1).run(); //同步 用main线程执行
        new Thread(mt2).run(); //同步 用main线程执行
        new Thread(mt3).run(); //同步 用main线程执行
        new Thread(mt1).start(); //异步 jvm新起一个线程执行
        new Thread(mt2).start(); //异步 jvm新起一个线程执行
        new Thread(mt3).start(); //异步 jvm新起一个线程执行

        System.out.println("main exit...");
    }


}

