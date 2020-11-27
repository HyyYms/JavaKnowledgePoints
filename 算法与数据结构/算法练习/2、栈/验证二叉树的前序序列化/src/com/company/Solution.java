package com.company;

/**
 * @program: 验证二叉树的前序序列化
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-27 10:53
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }

        int slots = 1;
        for (int i = 0; i < preorder.length(); i++) {
            if (preorder.charAt(i) == ',') {
                slots--;
                if (slots < 0) {
                    return false;
                }
                if (preorder.charAt(i - 1) != '#') {
                    slots += 2;
                }
            }
        }
        slots += preorder.charAt(preorder.length() - 1) == '#' ? -1 : 2;
        return slots == 0;
    }
}
