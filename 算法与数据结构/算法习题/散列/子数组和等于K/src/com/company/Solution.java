package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: 子数组和等于K
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-06 19:49
 **/
public class Solution {

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        int ans = 0;
        int temp = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k)) {
                ans += map.get(nums[i] - k);
            }
            temp = map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1;
            map.put(nums[i], temp);
        }
        return ans;
    }
}
