package com.zhangaoyun.mapper;

import com.zhangaoyun.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
    User selectBypassid(int passid);
    void insertAll(User user);
}
