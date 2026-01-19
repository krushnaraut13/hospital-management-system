package com.example.HospitalManagementSystem.service;

import org.springframework.stereotype.Service;
import com.example.HospitalManagementSystem.entity.User;
import com.example.HospitalManagementSystem.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user)
    {
        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password)
    {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!user.getPassword().equals(password))
        {
            throw new RuntimeException("Invalid password");
        }
        return user;
    }
}
