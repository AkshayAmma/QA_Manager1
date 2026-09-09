package com.company.qamanager.service;

import com.company.qamanager.entity.UserStory;
import com.company.qamanager.repository.UserStoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStoryService {

    private final UserStoryRepository repository;

    public UserStoryService(UserStoryRepository repository) {
        this.repository = repository;
    }

    public UserStory save(UserStory story) {
        return repository.save(story);
    }

    public List<UserStory> findAll() {
        return repository.findAll();
    }
}