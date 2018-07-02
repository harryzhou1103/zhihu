package com.zhihu.model;

import lombok.Data;

@Data
public class User {
    private int id;

    public User(int id) {
        this.id = id;
    }
}
