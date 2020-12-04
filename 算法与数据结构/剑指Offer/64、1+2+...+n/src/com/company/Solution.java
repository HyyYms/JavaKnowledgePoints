package com.company;

/**
 * @program: 64、1+2+...+n
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-04 15:22
 **/
public class Solution {

    int res = 0;

    public int sumNums(int n) {
        boolean flag = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }

}
