package com.company;

/**
 * @program: 命令模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-18 11:42
 **/
public class PlayAction implements Action {

    private Player player;

    public PlayAction(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.play();
    }
}
