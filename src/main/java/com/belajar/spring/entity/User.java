package com.belajar.spring.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by sukenda on 28/07/18.
 * Project Belajar
 */
@Getter
@Setter
public class User {

    private int id;
    private String username;
    private String password;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
