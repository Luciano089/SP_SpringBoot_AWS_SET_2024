package com.example.springCourse.Repositories;

import com.example.springCourse.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Long> {

}
