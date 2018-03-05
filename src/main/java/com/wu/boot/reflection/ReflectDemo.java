package com.wu.boot.reflection;

import com.wu.boot.annotation.MyAnStudent;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;


@MyAnStudent(name = "class_name")
public class ReflectDemo {

    @MyAnStudent(name = "field_name")
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

    public static void main(String[] args) throws Exception {
        Class className1 = ReflectDemo.class;
        Class className2 = new ReflectDemo().getClass();
        Class className3 = Class.forName("com.wu.boot.reflection.ReflectDemo");
        System.out.println(className1 == className2);
        System.out.println(className1 == className3);

        Constructor[] constructors = className1.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i]);
        }

        MyAnStudent myAnStudent = (MyAnStudent) className1.getAnnotation(MyAnStudent.class);
        System.out.println(myAnStudent.name());

        Field field=className1.getDeclaredField("name");

        MyAnStudent fieldAn=field.getAnnotation(MyAnStudent.class);
        System.out.println(fieldAn.name());

        Constructor constructor;
        constructor = className1.getConstructor(null);

        ReflectDemo demo=(ReflectDemo)constructor.newInstance();
        demo.setName(fieldAn.name());

        System.out.println(demo.getName());


    }

}
