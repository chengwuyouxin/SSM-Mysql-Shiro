package com.lpq.personallibrary.service;

import com.lpq.personallibrary.dao.UserMapper;
import com.lpq.personallibrary.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public int createUser(User user){
        return userMapper.createUser(user);
    }

    public User findUserByUsername(String username){
        return userMapper.findUserByUsername(username);
    }

    public Set<String> findRoles(String username){
        return userMapper.findRoles(username);
    }

    public Set<String> findPermissions(String username){
        return userMapper.findPermissions(username);
    }
}
