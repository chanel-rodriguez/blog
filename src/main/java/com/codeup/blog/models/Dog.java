package com.codeup.blog.models;

import javax.persistence.*;

@Entity
@Table(name="dogs")
public class Dog {

    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String state_residing;

    public Dog(Long id, int age, String name, String state_residing) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.state_residing = state_residing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getState_residing() {
        return state_residing;
    }

    public void setState_residing(String state_residing) {
        this.state_residing = state_residing;
    }
}
