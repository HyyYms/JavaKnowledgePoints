package com.company.kpi;

/**
 * @program: 访问者模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-21 16:46
 **/
public class Test {

    public static void main(String[] args) {
        BusinessReport report = new BusinessReport();
        System.out.println("==========CEO看报表===============");
        report.showReport(new CEOVisitor());
        System.out.println("==========CTO看报表===============");
        report.showReport(new CTOVisitor());
    }

}
