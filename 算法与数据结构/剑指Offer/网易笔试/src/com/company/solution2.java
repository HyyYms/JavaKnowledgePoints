package com.company;

import java.util.Scanner;

/**
 * @program: 网易笔试
 * @description:
 * @author: Mr.Huang
 * @create: 2021-03-27 16:18
 **/
public class solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer length = Integer.valueOf(sc.nextLine());
        String[] splits = sc.nextLine().split(" ");
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(splits[i]);
        }
        int res = solution(nums);
        System.out.println(res);
    }

    public static int solution(int[] nums) {
        int[] nums1 = new int[nums.length];
        int[] nums2 = new int[nums.length];

        nums1[0] = 1;
        nums2[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int temp = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i] && nums2[j] > temp) {
                    temp = nums2[j];
                }
            }
            nums1[i] = Math.max(1, max + 1);
            temp = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[i] && nums1[j] > temp) {
                    temp = nums[j];
                }
            }
            nums2[i] = Math.max(1, max + 1);
            max = Math.max(max, Math.max(nums1[i], nums2[i]));
        }
        return max;
    }
}
