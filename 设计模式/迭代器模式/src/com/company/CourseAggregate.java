package com.company;

/**
 * @program: 迭代器模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-18 09:39
 **/
public interface CourseAggregate {

    void add(Course courses);

    void remove(Course courses);

    Iterator<Course> iterator();
}
