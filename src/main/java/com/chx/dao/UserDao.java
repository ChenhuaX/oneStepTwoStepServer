package com.chx.dao;


import com.chx.domain.User;
import org.apache.ibatis.annotations.Mapper;
//关联mybatis
@Mapper
public interface UserDao {
    void addUser(User user);

    User getUserByOpendId(String opendId);

    void updateUser(User user);
}
