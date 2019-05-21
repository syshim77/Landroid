package org.androidtown.mylist;

public class SingerItem {
    /*data 저장*/

    String name;
    String age;

    public SingerItem(){

    }

    public SingerItem(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
