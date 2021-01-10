package com.company;

import java.util.HashMap;

/**
 * @program: 删除子数组的最大得分
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-23 10:50
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().maximumUniqueSubarray(new int[]{
                4,2,4,5,6
        });
    }
    public int maximumUniqueSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (right = 0; right < nums.length; right++) {
            if (map.containsKey(nums[right])) {
                map.remove(nums[left]);
                max -= nums[left];
                left++;
            } else {
                map.put(nums[right], 1);
                max += nums[right];
                right++;
            }
        }
        return max;
    }
}
