package com.company;

/**
 * @program: 打印从1到最大的n位数
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-05 09:35
 **/
public class Solution {

    // 无考虑大数问题
    public int[] printNumbers(int n) {
        int max = (int) (Math.pow(10,n) - 1);
        int[] nums = new int[max];
        for(int i = max; i > 0; i--){
            nums[i-1] = i;
        }
        return nums;
    }
}
