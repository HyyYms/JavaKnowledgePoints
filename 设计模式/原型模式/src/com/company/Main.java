package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConcretrPrototype prototype = new ConcretrPrototype();
        prototype.setAge(18);
        prototype.setName("Tom");

        List<String> hobbies = new ArrayList<>();
        hobbies.add("游戏");
        hobbies.add("小说");
        prototype.setHobbies(hobbies);

        // 拷贝原型对象
        ConcretrPrototype cloneType = prototype.deepClone();
        cloneType.getHobbies().add("睡觉");

        System.out.println("原型对象：" + prototype);
        System.out.println("拷贝对象：" + cloneType);
        System.out.println(prototype == cloneType);

        System.out.println("原型对象的爱好：" + prototype.getHobbies());
        System.out.println("拷贝对象的爱好：" + cloneType.getHobbies());
        System.out.println(prototype.getHobbies() == cloneType.getHobbies());
    }
}
