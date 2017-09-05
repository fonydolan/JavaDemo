package com.dolan.demo.springboot.domain;

public class UserPojo {

    private Long ID;
    private String Name;
    private Integer Age;

    public Integer getAge() {
        return Age;
    }

    public Long getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

}
