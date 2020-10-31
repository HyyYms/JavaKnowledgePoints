package com.company;

/**
 * @program: 切木头
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-28 15:59
 **/
public class WoodCut {

    public static void main(String[] args) {
        int[] L = new int[]{232, 124, 456};
        System.out.println(new WoodCut().woodCut(L, 7));
    }

    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) {
            return 0;
        }
        int start = 0;
        int end = getMax(L);
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (getPieces(L, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (getPieces(L, end) >= k) {
            return end;
        }
        if (getPieces(L, start) >= k) {
            return start;
        }
        return 0;
    }

    private int getPieces(int[] l, int mid) {
        int pieces = 0;
        for (int i = 0; i < l.length; i++) {
            pieces += l[i] / mid;
        }
        return pieces;
    }

    private int getMax(int[] l) {
        int max = l[0];
        for (int i = 1; i < l.length; i++) {
            if (l[i] > max) {
                max = l[i];
            }
        }
        return max;
    }
}
