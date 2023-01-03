package com.xcode.icu.exam;

public class MyThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000 * 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
