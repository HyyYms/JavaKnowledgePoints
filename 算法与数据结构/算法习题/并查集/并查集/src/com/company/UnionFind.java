package com.company;

import java.util.HashMap;

/**
 * @program: 并查集
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-09 16:12
 **/
public class UnionFind {


    HashMap<Integer, Integer> father = new HashMap<>();

    public UnionFind(Integer n) {
        for (int i = 0; i < n; i++) {
            father.put(i, i);
        }
    }

    public Integer find(Integer x) {
        Integer parent = father.get(x);
        while (!parent.equals(father.get(parent))) {
            parent = father.get(parent);
        }
        Integer temp = -1;
        Integer fa = father.get(x);
        while (!fa.equals(father.get(fa))) {
            temp = father.get(fa);
            father.put(fa, parent);
            fa = temp;
        }
        return parent;
    }

    public void union(Integer x, Integer y) {
        Integer fa_x = father.get(x);
        Integer fa_y = father.get(y);
        if (!fa_x.equals(fa_y)) {
            father.put(fa_x, fa_y);
        }
    }
}
