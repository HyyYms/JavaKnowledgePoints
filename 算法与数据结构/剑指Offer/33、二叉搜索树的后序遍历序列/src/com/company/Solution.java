package com.company;

/**
 * @program: 33、二叉搜索树的后序遍历序列
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-30 10:43
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(
                new Solution().verifyPostorder3(new int[]{
                        4, 6, 7, 5
                })
        );
    }

    // 改进我的算法1
    public boolean verifyPostorder3(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        return verify3(postorder, 0, postorder.length - 1);
    }

    private boolean verify3(int[] postorder, int leftStart, int rootNum) {
        if (leftStart >= rootNum) {
            return true;
        }
        int rightStart = leftStart;
        while (postorder[rightStart] < postorder[rootNum]) {
            rightStart++;
        }
        int temp = rightStart;
        while (temp < rootNum) {
            if (postorder[temp] < postorder[rootNum]) {
                return false;
            } else {
                temp++;
            }
        }
        return verify3(postorder, leftStart, rightStart - 1)
                && verify3(postorder, rightStart, rootNum - 1);
    }

    // 通过k判断是否符合二叉搜索树的性质
    public boolean verifyPostorder2(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        return verify2(postorder, 0, postorder.length - 1);
    }

    private boolean verify2(int[] postorder, int leftStart, int rootNum) {
        if (leftStart > rootNum) {
            return true;
        }
        int k = 0;
        while (postorder[k] < postorder[rootNum]) {
            k++;
        }
        int rightStart = k;
        while (postorder[k] > postorder[rootNum]) {
            k++;
        }
        return k == rootNum &&
                verify2(postorder, leftStart, rightStart - 1)
                && verify2(postorder, rightStart, rootNum - 1);
    }

    // 超出时间限制
    public boolean verifyPostorder1(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        return verify1(postorder, 0, postorder.length - 1);
    }

    private boolean verify1(int[] postorder, int startNum, int rootNum) {
        if (startNum > rootNum) {
            return true;
        }
        int rootVal = postorder[rootNum];
        int rightStart = 0;
        for (int i = startNum; i < rootNum; i++) {
            if (postorder[i] > rootVal) {
                rightStart = i;
                for (int j = rightStart; j < rootNum; j++) {
                    if (postorder[j] < rootVal) {
                        return false;
                    }
                }
                for (int j = startNum; j < rightStart; j++) {
                    if (postorder[j] > rootVal) {
                        return false;
                    }
                }
                break;
            }
        }
        return verify1(postorder, startNum, rightStart - 1)
                && verify1(postorder, rightStart, rootNum - 1);
    }


}
