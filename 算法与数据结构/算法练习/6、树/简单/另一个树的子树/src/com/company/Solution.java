package com.company;

import java.util.Comparator;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

/**
 * @program: 另一个树的子树
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-15 10:13
 **/
public class Solution {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, 10, 5500));
        list.add(new Employee(2, 20, 4800));
        list.add(new Employee(3, 40, 14500));
        list.add(new Employee(4, 40, 44500));
        list.add(new Employee(5, 50, 6500));
        list.add(new Employee(6, 50, 7500));
        list.add(new Employee(7, 10, 4500));
        new Solution().sort(list);
        for (Employee e : list) {
            System.out.println(e);
        }
    }

    public List<Employee> sort(List<Employee> list) {
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getDeptid() < o2.getDeptid()) {
                    return -1;
                } else if (o1.getDeptid() > o2.getDeptid()) {
                    return 1;
                } else {
                    if (o1.getSalary() < o1.getSalary()) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });

        int deptid = 0;
        int rank = 1;
        for (Employee e : list) {
            if (deptid == e.getDeptid()) {
                e.setRank(rank++);
            } else {
                rank = 1;
            }
            deptid = e.getDeptid();
        }
        return list;
    }
}
