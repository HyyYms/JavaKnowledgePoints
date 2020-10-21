package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: 命令模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-18 11:43
 **/
public class Controller {

    private List<Action> actionList = new ArrayList<>();

    public void addAction(Action action) {
        actionList.add(action);
    }

    public void execute(Action action) {
        action.execute();
    }

    public void execute() {
        for (Action action : actionList) {
            action.execute();
        }
        actionList.clear();
    }
}
