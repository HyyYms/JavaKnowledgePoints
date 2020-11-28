package com.company;

/**
 * @program: 16、数值的整数次方
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-28 21:31
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2.0, 10));
    }

    public double myPow(double x, int n) {
        //如果n等于0，直接返回1
        if (n == 0) {
            return 1;
        }
        //如果n小于0，把它改为正数，并且把1/x提取出来一个
        if (n < 0) {
//            一般情况下
//            计算机是按照补码来保存的，
//            所以把-2147483648看成2个部分，
//            先把2147483648看成无符号整型 2的31次，
//            机器数是0x80000000,然后对其取补码，
//            结果仍为0x80000000，
//            猜测Java负数取相反数过程为取补码的逆过程，
//            首先-1，然后再取反，然后再符号位取反，
//            0x80000000-1=0x7FFFFFFF，取反后0x00000000，符号位取反后仍为0x80000000。
//            所以计算机在求-2147483648的相反数是仍然为-2147483648。
//            同时比较-2147483648和2147483648时会发现返回的结果是二者相等。
//            根据题目那个代码 会一直递归mypow（1/x,-n)里面的-n一直都是-2147483648
//            无法完成变成正的 也就无法递归下去
            return myPow(1 / x, -n - 1) * 1 / x;
        }
        //根据n是奇数还是偶数来做不同的处理
        return n % 2 != 0 ? x * myPow(x * x, n / 2) : myPow(x * x, n / 2);
    }
}
