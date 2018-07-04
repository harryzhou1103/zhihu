package com.zhihu.model;

import lombok.Data;

import java.util.Date;


@Data
public class LoginTicket {
    private int id;
    private int userId;
    private Date expired;
    private int status;
    private String ticket;
}
