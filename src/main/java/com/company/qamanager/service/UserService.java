package com.company.qamanager.service;

import com.company.qamanager.entity.User;
import com.company.qamanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User login(String email, String password) {

        User user = repository.findByEmail(email)
                .orElse(null);

        if (user != null &&
                user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }

    public User getUser(Long id) {

        return repository.findById(id).orElse(null);

    }
    public void updateUser(User user) {
        repository.save(user);
    }
}