package com.example.springCourse.Services;

import com.example.springCourse.Entities.User;
import com.example.springCourse.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User FindById(Long id){
         Optional<User> obj = Optional.of(repository.findById(id).get());
         return obj.get();
    }
}
