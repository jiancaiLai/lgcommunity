package com.gdlgxy.lgcommunity.dao;

import com.gdlgxy.lgcommunity.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectById(int id);

    User selectByName(String name);

    User selectByEmail(String email);

    void insertUser(User user);

    void updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);

}
