package com.company;

import java.util.Arrays;

/**
 * @program: 合并两个有序数组
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-13 22:56
 **/
public class Solution {

    // 先合并再排序
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
