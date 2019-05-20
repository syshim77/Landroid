package com.example.mylist;

public class SingerItem {
    String name;
    String age;

    public SingerItem() {

    }

    public SingerItem(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
