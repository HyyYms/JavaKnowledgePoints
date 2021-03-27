package com.company;


import java.util.Scanner;

public class Solution2 {

    static int MOD = 1000000007;

    public static void main(String[] args) {
        long[] t = new long[200005];
        t[0] = 1L;
        for (int i = 1; i <= 200000; i++) {
            t[i] = (t[i - 1] % MOD * 2) % MOD;
        }
        Scanner in = new Scanner(System.in);
        String nAndM = in.nextLine();
        int n = nAndM.charAt(0) - '0';
        int m = nAndM.charAt(2) - '0';
        String numsString = in.nextLine();
        String[] split = numsString.split(" ");
        int[] nums = new int[n];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1];
            if (nums[i] % 2 != 0) {
                nums[i] = nums[i] + 1;
            }
        }
        for (int i = 0; i < m; i++) {
            String mStr = in.nextLine();
            String[] mSplit = mStr.split(" ");
            int flag = Integer.parseInt(mSplit[0]);
            int left = Integer.parseInt(mSplit[1]);
            int right = Integer.parseInt(mSplit[2]);
//            int[] numsM = new int[right - left + 1];
            int num = nums[right] - nums[left - 1];
            int ans = 0;
            if (flag == 1) {
                ans = (int) ((t[num] - 1 + MOD) % MOD);
            } else {
                ans = (int) ((t[right - left + 1] - t[num] + MOD) % MOD);
            }
            System.out.println(ans % MOD);
//
//            for (int j = 0; j < right - left + 1; j++) {
//                numsM[j] = nums[j + left];
//            }
        }
    }
//
//    public static void solution(int[] nums, Integer sum,
//                                Integer start, Integer flag) {
//        if (flag == 1) {
//            if (sum % 2 != 0) {
//                res = res + 1;
//            }
//        } else {
//            if (sum % 2 == 0) {
//                res = res + 1;
//            }
//            res = res % (1000000007);
//        }
//        for (int i = start; i < nums.length; i++) {
//            sum *= nums[i];
//            solution(nums, sum, i + 1, flag);
//            sum /= nums[i];
//        }
//    }
}
