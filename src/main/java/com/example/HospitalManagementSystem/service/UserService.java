package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.entity.User;

public interface UserService {
    User register(User user);
    User login(String email, String password);
}
