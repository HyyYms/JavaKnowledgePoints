package com.company;

import java.io.ObjectInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ByteArrayOutputStream;

import java.io.Serializable;
import java.util.List;

/**
 * @program: 原型模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-23 11:31
 **/
public class ConcretrPrototype implements Cloneable, Serializable {
    private int age;
    private String name;
    private List<String> hobbies;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConcretrPrototype deepClone() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);

            return (ConcretrPrototype) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "ConcretrPrototype{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}
