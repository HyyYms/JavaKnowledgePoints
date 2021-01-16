package com.company;

/**
 * @program: 另一个树的子树
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-15 10:12
 **/

public class Employee {

    private int empid;
    private int deptid;
    private int salary;
    private int rank;

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Employee() {
    }

    public Employee(int empid, int deptid, int salary) {
        this.empid = empid;
        this.deptid = deptid;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", deptid=" + deptid +
                ", salary=" + salary +
                ", rank=" + rank +
                '}';
    }
}
