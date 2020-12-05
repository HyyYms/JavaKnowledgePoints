package com.company;

import java.util.*;

/**
 * @program: 59、滑动窗口的最大值
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-05 17:17
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().maxSlidingWindow2(new int[]{
                1, 3, 1, 2, 0, 5
        }, 3);
    }

    // 双端队列
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] > queue.peekLast()) {
                queue.pollLast();
            }
            queue.offerLast(nums[i]);
        }
        res[0] = queue.peekFirst();
        for (int i = k; i < nums.length; i++) {
            if (nums[i - k] == queue.peekFirst()) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[i] > queue.peekLast()) {
                queue.pollLast();
            }
            queue.offerLast(nums[i]);
            res[i - k + 1] = queue.peekFirst();
        }
        return res;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int start = 0;
        int end = start + k;
        int[] res = new int[nums.length - k + 1];
        while (end <= nums.length) {
            int temp = nums[start];
            for (int i = start; i < end; i++) {
                temp = Math.max(nums[i], temp);
            }
            res[start] = temp;
            end++;
            start++;
        }
        return res;
    }
}
