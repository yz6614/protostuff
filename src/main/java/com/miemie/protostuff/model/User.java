package com.miemie.protostuff.model;

import lombok.Builder;
import lombok.Data;


public class User {

    private String id;

    private String name;

    private Integer age;



    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
