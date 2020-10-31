package com.company;

/**
 * @program: 在旋转有序的数组中搜索
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-28 11:07
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(Solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[start]) {
                if (nums[mid] >= target && target >= nums[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

    public static int mySearch(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 旋转发生在右边
            if (nums[mid] > nums[end]) {
                if (target > nums[mid] || target < nums[0]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            // 无发生旋转或者是旋转开头发生在左边
            else {
                // 无发生旋转
                if (nums[start] < nums[end]) {
                    if (target < nums[mid]) {
                        end = mid;
                    } else {
                        start = mid;
                    }
                }
                // 旋转的开头发生在左边
                else {
                    if (target < nums[mid]) {
                        end = mid;
                    } else {
                        if (target < nums[0]) {
                            start = mid;
                        } else {
                            end = mid;
                        }
                    }
                }
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}

