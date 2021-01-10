package com.company;

import java.util.*;

/**
 * @program: 子集
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-07 22:39
 **/
public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> subsets = new Solution().subsets(new int[]{
                1, 2, 3
        });
        System.out.println(subsets);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            List<Integer> list = new ArrayList<Integer>();
            result.add(list);
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(result, nums, list, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, List<Integer> list, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(result, nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
