package com.company;

import static java.lang.Thread.sleep;

/**
 * @program: 腾讯3.18一面
 * @description:
 * @author: Mr.Huang
 * @create: 2021-03-20 20:33
 **/
public class Demo {

    public static class MyThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "_____" + i);
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
        Integer num = 10;
        for (int i = 0; i < 10; i++) {
            synchronized (num) {
                num--;
            }
            System.out.println(num);
        }
//        new Thread(new MyThread()).start();
//        new Thread(new MyThread()).start();
//        new Thread(new MyThread()).start();
//// Java 8 函数式编程，可以省略MyThread类
//        new Thread(() -> {
//            System.out.println("Java 8 匿名内部类");
//        }).start();
    }
//    public static class MyThread extends Thread {
//        @Override
//        public void run() {
//            for (int i = 0; i < 10; i++) {
//                System.out.println(Thread.currentThread().getName() + "_____" + i);
//                try {
//                    sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}
