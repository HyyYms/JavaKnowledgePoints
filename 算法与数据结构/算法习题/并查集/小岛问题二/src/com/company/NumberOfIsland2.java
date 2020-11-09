package com.company;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

/**
 * @program: 小岛问题二
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-09 16:31
 **/
public class NumberOfIsland2 {

    public static void main(String[] args) {
        int n = 4;
        int m = 5;
        Point[] operators = new Point[4];
        Point point1 = new Point(1, 1);
        Point point2 = new Point(0, 1);
        Point point3 = new Point(3, 3);
        Point point4 = new Point(3, 4);
        operators[0] = point1;
        operators[1] = point2;
        operators[2] = point3;
        operators[3] = point4;
        List<Integer> list = new NumberOfIsland2().numIslands(n, m, operators);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    class UnionFind {

        private HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();

        public UnionFind(int row, int column) {
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
        List<Integer> result = new ArrayList<>();
        if (operators == null || operators.length == 0) {
            return result;
        }
        int count = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        UnionFind unionFind = new UnionFind(n, m);
        boolean[][] isIsland = new boolean[n][m];

        for (Point point : operators) {
            int x = point.x;
            int y = point.y;
            if (!isIsland[x][y]) {
                isIsland[x][y] = true;
                count++;
                Integer id = unionFind.convertId(x, y, n);
                for (int k = 0; k < 4; k++) {
                    int newX = x + dx[k];
                    int newY = y + dy[k];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && isIsland[newX][newY]) {
                        Integer newId = unionFind.convertId(newX, newY, n);
                        Integer father = unionFind.find(id);
                        Integer nfather = unionFind.find(newId);
                        if (!father.equals(nfather)) {
                            count--;
                            unionFind.union(nfather, father);
                        }
                    }
                }
            }
            result.add(count);
        }
        return result;
    }
}
