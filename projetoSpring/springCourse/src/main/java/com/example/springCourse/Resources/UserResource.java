package com.example.springCourse.Resources;

import com.example.springCourse.Entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<User> findAll() {
      User user = new User(1L, "Luciano", "luciano@gmail.com", "2727881772", "23523");
      return ResponseEntity.ok().body(user);
    }
}
