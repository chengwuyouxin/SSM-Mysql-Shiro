package com.lpq.personallibrary.dao;

import com.lpq.personallibrary.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserMapper {
    int createUser(User user); //创建用户
    User findUserByUsername(String username);//查找用户
    Set<String> findRoles(String username);//根据用户名查找角色
    Set<String> findPermissions(String username);//根据用户名查找权限
}
