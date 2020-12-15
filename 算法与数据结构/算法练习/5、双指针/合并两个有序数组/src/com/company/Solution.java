package com.company;

import java.util.Arrays;

/**
 * @program: 合并两个有序数组
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-13 22:56
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().merge3(new int[]{
                        1, 2, 3, 0, 0, 0
                }, 3,
                new int[]{
                        2, 5, 6
                }, 3);
    }

    // 先合并再排序
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    // 双指针_从前往后
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] numsCopy = new int[m + n];
        int p1 = 0;
        int p2 = 0;
        int cur = 0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                numsCopy[cur] = nums1[p1];
                p1++;
            } else {
                numsCopy[cur] = nums2[p2];
                p2++;
            }
            cur++;
        }
        while (p1 < m) {
            numsCopy[cur++] = nums1[p1++];
        }
        while (p2 < n) {
            numsCopy[cur++] = nums2[p2++];
        }
        System.arraycopy(numsCopy, 0, nums1, 0, m + n);
    }

    // 双指针_从后往前
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int cur = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[cur] = nums1[p1];
                p1--;
            } else {
                nums1[cur] = nums2[p2];
                p2--;
            }
            cur--;
        }
        while (p1 >= 0){
            nums1[cur--] = nums1[p1--];
        }
        while (p2 >= 0){
            nums1[cur--] = nums2[p2--];
        }
    }

    // 双指针——从后往前
    public void merge4(int[] A, int m, int[] B, int n) {
        if(A == null || A.length == 0 || B == null || B.length == 0){
            return;
        }
        int p1 = m;
        int p2 = n;
        while(p2 > 0) {
            if(p1 > 0 && A[p1 - 1] < B[p2 - 1]) {
                A[p1 + p2 - 1] = B[p2 - 1];
                p2--;
            } else {
                if(p1 > 0) {
                    A[p1 + p2 - 1] = A[p1 - 1];
                    p1--;
                } else {
                    A[p2 - 1] = B[p2 - 1];
                    p2--;
                }
            }
        }
    }
}
