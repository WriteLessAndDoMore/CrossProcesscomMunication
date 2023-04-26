package com.android.mylibrary.bean;

import java.io.Serializable;

/**
 * @description:
 * @Author: dongxiangyang
 * @Date: 2023/4/10 下午4:33
 */
public class User2 implements Serializable {
    /**
     *  序列化和反序列的关键
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
