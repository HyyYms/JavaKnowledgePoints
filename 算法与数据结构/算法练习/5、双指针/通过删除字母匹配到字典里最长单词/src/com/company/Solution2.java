package com.company;

import java.util.Arrays;


/**
 * @program: 安排工作以达到最大收益
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-20 22:00
 **/
public class Solution2 {

    public static void main(String[] args) {
        new Solution2().maxProfitAssignment2(
                new int[]{2, 4, 6, 8, 10},
                new int[]{10, 20, 30, 40, 50},
                new int[]{4, 5, 6, 7});
    }

    // 使用快排进行难度和资金的排序
    public int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) {
        if (worker == null || worker.length == 0) {
            return 0;
        }
        Arrays.sort(worker);
        quickSort(difficulty, profit);
        int res = 0;
        int maxPro = 0;
        int maxDiffNum = 0;
        for (int value : worker) {
            while (maxDiffNum < difficulty.length &&
                    value >= difficulty[maxDiffNum]) {
                maxPro = Math.max(maxPro, profit[maxDiffNum]);
                maxDiffNum++;
            }
            res += maxPro;
        }
        return res;
    }

    private void quickSort(int[] difficulty, int[] profit) {
        sort(difficulty, profit, 0, difficulty.length - 1);
    }

    private void sort(int[] difficulty, int[] profit, int start, int end) {
        if (start > end) {
            return;
        }
        int pivot = difficulty[start];
        int left = start;
        int right = end;
        while (left <= right) {
            while (left <= right && difficulty[left] < pivot) {
                left++;
            }
            while (left <= right && difficulty[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int diffTemp = difficulty[left];
                int proTemp = profit[left];
                difficulty[left] = difficulty[right];
                profit[left] = profit[right];
                difficulty[right] = diffTemp;
                profit[right] = proTemp;
                left++;
                right--;
            }
        }
        sort(difficulty, profit, start, right);
        sort(difficulty, profit, left, end);
    }

    public int maxProfitAssignment1(int[] difficulty, int[] profit, int[] worker) {
        if (worker == null || worker.length == 0) {
            return 0;
        }
        int max = 0;
        for (int value : worker) {
            max += maxProfit(difficulty, profit, value);
        }
        return max;
    }

    private int maxProfit(int[] difficulty, int[] profit, int worker) {
        int p = 0;
        int max = 0;
        for (p = 0; p < difficulty.length; p++) {
            if (difficulty[p] > worker) {
                continue;
            }
            max = Math.max(max, profit[p]);
        }
        return max;
    }
}
