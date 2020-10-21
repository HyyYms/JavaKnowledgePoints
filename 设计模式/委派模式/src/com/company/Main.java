package com.company;

public class Main {

    public static void main(String[] args) {
        Boss boss = new Boss();
        Leader leader = new Leader();
        boss.command("PPT", leader);
        boss.command("Word", leader);
        boss.command("TXT", leader);
    }
}
