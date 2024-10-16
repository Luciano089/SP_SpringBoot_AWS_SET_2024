package com.luciano.demo_park_api.controller;

import com.luciano.demo_park_api.entity.User;
import com.luciano.demo_park_api.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;


    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User userToSave = userService.save(user);
        return ResponseEntity.ok().body(userToSave);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updatePassword(@PathVariable Long id, @RequestBody User user) {
        User updatePassword = userService.updatePassword(id, user.getPassword());
        return ResponseEntity.ok().body(updatePassword);
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

}
