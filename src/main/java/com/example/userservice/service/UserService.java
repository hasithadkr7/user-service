package com.example.userservice.service;

import com.example.userservice.VO.ResponseTemplateVO;
import com.example.userservice.entity.User;

public interface UserService {
    public User saveUser(User user);

    ResponseTemplateVO getUserWithDepartment(Long userId);
}
