package com.company;

import java.util.LinkedList;

/**
 * @program: 文件夹操作日志搜集器
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-23 18:45
 **/
public class Solution {

    public int minOperations(String[] logs) {
        if (logs == null || logs.length == 0) {
            return 0;
        }
        LinkedList<String> stack = new LinkedList<>();
        for (String log : logs) {
            if ("../".equals(log) && !stack.isEmpty()) {
                stack.pop();
            } else if ("./".equals(log) || ("../".equals(log) && stack.isEmpty())) {
                continue;
            } else {
                stack.push(log);
            }
        }
        return stack.size();
    }
}
