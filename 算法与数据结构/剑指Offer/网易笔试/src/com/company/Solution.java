package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = Integer.parseInt(sc.nextLine());
        String numStr = sc.nextLine();
        String[] split = numStr.split(" ");
        int[] nums = new int[length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int res = solution(nums, 6);
        System.out.println(res);
    }

    public static int solution(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = (sum % k + k) % k;
            if (mod == 0) {
                if (sum > res) {
                    res = sum;
                }
            }
        }
        return res;
    }
}
