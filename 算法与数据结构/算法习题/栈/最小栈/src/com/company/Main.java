package com.company;

public class Main {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        System.out.println(minStack);
        minStack.push(0);
        System.out.println(minStack);
        minStack.push(-3);
        System.out.println(minStack);
        minStack.getMin();
        System.out.println(minStack);
        minStack.pop();
        System.out.println(minStack);
        minStack.top();
        System.out.println(minStack);
        minStack.getMin();
        System.out.println(minStack);
    }
}
