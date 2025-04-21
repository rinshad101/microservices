package com.bookstore.user_service.service;

import com.bookstore.user_service.model.User;
import com.bookstore.user_service.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo repo;

    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return repo.findById(id);
    }

    public User createUser(User user) {
        return repo.save(user);
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }
}
