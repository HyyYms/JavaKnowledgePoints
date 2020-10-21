package com.company;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        Controller controller = new Controller();

        // 单个命令
        controller.execute(new PlayAction(player));

        // 命令宏
        controller.addAction(new PlayAction(player));
        controller.addAction(new PauseAction(player));
        controller.addAction(new StopAction(player));
        controller.execute();
    }
}
