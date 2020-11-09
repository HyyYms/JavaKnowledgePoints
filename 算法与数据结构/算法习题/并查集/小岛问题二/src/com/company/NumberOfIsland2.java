package com.company;

import java.util.HashMap;

import java.util.List;

/**
 * @program: 小岛问题二
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-09 16:31
 **/
public class NumberOfIsland2 {

    class UnionFind {
        private HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();

        public void unionFind(int row, int column) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    Integer id = convertId(i, j, row);
                    father.put(id, id);
                }
            }
        }

        public Integer convertId(int x, int y, int row) {
            return x * row + y;
        }

        public Integer find(int x) {
            Integer parent = father.get(x);
            while (!parent.equals(father.get(parent))) {
                parent = father.get(parent);
            }
            int temp = -1;
            Integer fa = father.get(x);
            while (!fa.equals(father.get(fa))) {
                temp = father.get(fa);
                father.put(fa, parent);
                fa = temp;
            }
            return parent;
        }

        public void union(int x, int y) {
            Integer faX = father.get(x);
            Integer faY = father.get(y);
            if (!faX.equals(faY)) {
                father.put(faX, faY);
            }
        }
    }

    public List<Integer> numIslands(int n, int m, Point[] operators) {

    }
}
