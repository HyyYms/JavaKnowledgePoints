package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Course java = new Course("Java");
        Course python = new Course("Python");
        Course js = new Course("JavaScript");

        CourseAggregate courseAggregate = new CourseAggregateImpl(new ArrayList());

        courseAggregate.add(java);
        courseAggregate.add(python);
        courseAggregate.add(js);

        System.out.println("---课程列表---");
        printCourse(courseAggregate);
        courseAggregate.remove(js);
        System.out.println("---删除操作后的课程列表---");
        printCourse(courseAggregate);
    }

    private static void printCourse(CourseAggregate courseAggregate) {
        Iterator<Course> iterator = courseAggregate.iterator();
        while (!iterator.hasNext()) {
            Course next = iterator.next();
            System.out.println("《" + next.getName() + "》");
        }
    }
}

