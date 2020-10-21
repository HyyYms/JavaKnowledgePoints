package com.company;

public class Main {

    public static void main(String[] args) {
        Message message = new SmsMessage();
        AbstractMessage abstractMessage = new NomalMessage(message);
        abstractMessage.sendMessage("请假申请","老师");

        message = new EmailMessage();
        abstractMessage = new UragencyMessage(message);
        abstractMessage.sendMessage("请假申请","老师");
    }
}
