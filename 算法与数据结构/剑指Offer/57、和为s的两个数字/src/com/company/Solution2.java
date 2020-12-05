package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: 57、和为s的两个数字
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-05 10:46
 **/
public class Solution2 {

    public static void main(String[] args) {
        System.out.println(9 / 2);
        System.out.println(new Solution2().findContinuousSequence(9));
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        int start = 1;
        int end = 1;
        int sum = 0;
        while (start <= target / 2 || end <= target / 2) {
            if (sum == target) {
                int[] nums = new int[end - start];
                for (int i = start; i < end; i++) {
                    nums[i - start] = i;
                }
                result.add(nums);
                sum += end;
                end++;
            } else if (sum < target) {
                sum += end;
                end++;
            } else {
                sum -= start;
                start++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
