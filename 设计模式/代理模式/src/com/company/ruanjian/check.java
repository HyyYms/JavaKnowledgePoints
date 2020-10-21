package com.company.ruanjian;

import java.util.List;
import java.util.Set;

/**
 * @program: 代理模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-07 15:39
 **/
public interface check {
    /**
     * 检查生成的题目
     *
     * @param question 题目
     * @param againstPolandSet 逆波兰式的集合
     * @return 返回检查结果
     */
    public Boolean checkQuestion(String question, Set<String> againstPolandSet);

    /**
     * 检查我的答案的正确率
     *
     * @param myAnswerList   我的答案
     * @param trueAnswerList 正确答案
     * @return 返回错误题号
     */
    public List<String> checkAnswer(List<String> myAnswerList, List<String> trueAnswerList);
}
