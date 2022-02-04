package com.example.userservice.service;

import com.example.userservice.VO.Department;
import com.example.userservice.VO.ResponseTemplateVO;
import com.example.userservice.entity.User;
import com.example.userservice.repositary.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Value("${user.service.base.url}")
    private String userServiceBaseUrl;

    @Autowired
    private RestTemplate restTemplate;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        log.info("Inside saveUser method in UserServiceImpl");
        return userRepository.save(user);
    }

    @Override
    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment method in UserServiceImpl");
        ResponseTemplateVO templateVO = new ResponseTemplateVO();
        User user = userRepository.findUserByUserId(userId);

        Department department =
                restTemplate.getForObject(userServiceBaseUrl+user.getDepartmentId(),
                        Department.class);
        templateVO.setUser(user);
        templateVO.setDepartment(department);
        return templateVO;
    }
}
