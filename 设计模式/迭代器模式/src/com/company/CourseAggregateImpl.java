package com.company;

import java.util.List;

/**
 * @program: 迭代器模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-18 10:48
 **/
public class CourseAggregateImpl implements CourseAggregate {

    private List courseList;

    public CourseAggregateImpl(List courseList) {
        this.courseList = courseList;
    }

    @Override
    public void add(Course course) {
        courseList.add(course);
    }

    @Override
    public void remove(Course course) {
        courseList.remove(course);
    }

    @Override
    public Iterator<Course> iterator() {
        return new IteratorImpl<>(courseList);
    }
}
