package com.luciano.demo_park_api.service;

import com.luciano.demo_park_api.entity.User;
import com.luciano.demo_park_api.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
// Serve para o lombok criar um construtor com a variavel UserRepository para o spring fazer a injeção de dependencia via metodo construtor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );
    }

    @Transactional
    public User updatePassword(Long id, String currentPassword, String newPassword , String password) {
        if(!newPassword.equals(password)) {
            throw new RuntimeException("Your new password does not match password confirmation");
        }
        User user = getUserById(id);

        if(!user.getPassword().equals(currentPassword)) {
            throw new RuntimeException("Password does not match");
        }
        user.setPassword(newPassword);
        return userRepository.save(user);
    }

    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
