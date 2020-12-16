package com.company;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: 寻找重复数
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-16 10:38
 **/
public class Solution {

    // 双指针——快慢指针
    /*
     * 对nums[] 数组建图，
     * 每个位置 i 连一条[i]i→nums[i] 的边。
     * 由于存在的重复的数字 target，
     * 因此 target 这个位置一定有起码两条指向它的边，
     * 因此整张图一定存在环，
     * 且我们要找到的 target 就是这个环的入口，
     * 那么整个问题就等价于 142. 环形链表 II。
     * */
    public int findDuplicate4(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    // Hash _ n
    public int findDuplicate3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                res = num;
                break;
            }
            map.put(num, 1);
        }
        return res;
    }

    // 利用排序算法进行简化n*logn
    public int findDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int p = 0;
        while (p + 1 < nums.length && nums[p] < nums[p + 1]) {
            p++;
        }
        return nums[p];
    }

    // n^2暴力解法
    public int findDuplicate1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            int p = i + 1;
            while (p < nums.length) {
                if (nums[p] == nums[i]) {
                    return nums[p];
                } else {
                    p++;
                }
            }
        }
        return -1;
    }
}
