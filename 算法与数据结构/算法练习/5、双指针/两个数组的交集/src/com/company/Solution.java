package com.company;

import java.util.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: 两个数组的交集
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-14 23:01
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().intersection(new int[]{
                1, 2, 2, 1
        }, new int[]{
                2, 2
        });
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums2[p2] < nums1[p1]) {
                p2++;
            } else {
                if (p1 == 0 || nums1[p1] != nums1[p1 - 1]) {
                    list.add(nums1[p1]);
                }
                p1++;
                p2++;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

