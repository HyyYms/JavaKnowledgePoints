package com.company.ruanjian;

import java.util.List;

/**
 * @program: 代理模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-07 15:34
 **/
public interface generate {
    /**
     * 生成题目
     *
     * @param naturalNumber 自然数的最大值
     * @return 返回题目
     */
    public String generateQuestion(Integer naturalNumber);

    /**
     * 生成答案
     *
     * @param againstPoland 逆波兰式
     * @return 返回答案
     */
    public String generateAnswer(String againstPoland);

    /**
     * 生成逆波兰式
     *
     * @param question 题目
     * @return 返回逆波兰式
     */
    public String generateAgainstPoland(String question);
}
