package com.zhihu.service;

import org.springframework.stereotype.Service;

@Service
public class ZhihuService {
    public String getMessage(int userId) {
        return "Hello Message:" + String.valueOf(userId);
    }

}
