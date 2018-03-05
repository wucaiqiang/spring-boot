package com.wu.boot.bean;

public class User {
    private String name;
    private int age;

    public User(){
        super();
    }

    public User(String name,int age){
        this.name=name;
        this.age=age;
    }
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
    public void init(){
        System.out.println("user init method do");
    }
    public void destory(){
        System.out.println("user destory method do");
    }
}
