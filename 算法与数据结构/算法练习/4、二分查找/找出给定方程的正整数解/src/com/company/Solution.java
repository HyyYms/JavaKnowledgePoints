package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: 找出给定方程的正整数解
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-11 16:16
 **/
public class Solution {

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        // 有序的排列可选择双指针
        List<List<Integer>> result = new ArrayList<>();
        int left = 1;
        int right = z;
        while (left <= z && right >= 1) {
            if (customfunction.f(left, right) == z) {
                List<Integer> list = new ArrayList<>();
                list.add(left);
                list.add(right);
                result.add(list);
                left++;
            } else if (customfunction.f(left, right) > z) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
