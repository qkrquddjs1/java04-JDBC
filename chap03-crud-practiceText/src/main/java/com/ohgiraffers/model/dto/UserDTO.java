package com.ohgiraffers.model.dto;

public class UserDTO {
    private int no;
    private String name;
    private String gender;
    private int age;

    public UserDTO() {
    }

    public UserDTO(int no, String name, String gender, int age) {
        this.no = no;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}

