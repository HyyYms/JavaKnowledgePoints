package com.company;

public class Main {

    public static void main(String[] args) {
        int a = fib(1);
        System.out.println(a);
    }

    public static int fib(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }


    public static int myFib(int n) {
        int a = 1;
        int b = 1;
        int c = 0;
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        }
        for (int i = 1; i < n; i++) {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return c;
    }
}
