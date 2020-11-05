package com.company;

public class Main {

    public static void main(String[] args) {
    CQueue cQueue = new CQueue();
    cQueue.appendTail(3);
    cQueue.deleteHead();
    cQueue.deleteHead();
    cQueue.deleteHead();
    }
}
//    public int deleteHead() {
//        if (deleteList.isEmpty()) {
//            while (!insertList.isEmpty()) {
//                deleteList.push(insertList.pop());
//            }
//        }
//        if (deleteList.isEmpty()) {
//            return -1;
//        } else {
//            return deleteList.pop();
//        }
//    }