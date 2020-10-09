package com.company.ruanjian;

import java.util.List;

public interface file {
    /**
     * 将生成的题目或答案输出至文件中
     * @param fileName 题目文件或答案文件的文件名
     * @param textList 题目或答案集合
     */
    public void writeToFile(String fileName, List<String> textList);


    /**
     * 将题目文件或答案文件转换为集合
     * @param fileName 题目文件或答案文件的文件名
     * @return 返回集合
     */
    public List<String> readFromFile(String fileName);
}
