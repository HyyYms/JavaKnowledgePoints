package com.company;

import java.util.*;

import java.util.Arrays;

/**
 * @program: 两个数组的交集2
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-14 16:38
 **/
public class Solution2 {

    public static void main(String[] args) {
        new Solution2().intersect2(new int[]{
                1, 2, 2, 1
        }, new int[]{
                2, 2
        });
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int value : nums1) {
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
        }
        for (int value : nums2) {
            if (map.containsKey(value) && map.get(value) > 0) {
                list.add(value);
                map.put(value, map.get(value) - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        List<Integer> list = new ArrayList<>();
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums2[p2] < nums1[p1]) {
                p2++;
            } else {
                list.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
