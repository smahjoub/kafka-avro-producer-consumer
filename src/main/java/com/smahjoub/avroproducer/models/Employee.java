package com.smahjoub.avroproducer.models;

public class Employee {

    private String name;
    private int age;
    private String[] mails;

    public Employee(){

    }

    public Employee(String name, int age, String[] emails){
        this.name = name;
        this.age = age;
        this.mails = emails;
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

    public String[] getMails() {
        return mails;
    }

    public void setMails(String[] mails) {
        this.mails = mails;
    }
}
