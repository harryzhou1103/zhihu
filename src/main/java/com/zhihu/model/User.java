package com.zhihu.model;

import lombok.Data;

@Data
public class User {
    private String id;
    private String name;
    private String password;
    private String salt;
    private String headUrl;

    public User(String id) {
        this.id = id;
    }
}
