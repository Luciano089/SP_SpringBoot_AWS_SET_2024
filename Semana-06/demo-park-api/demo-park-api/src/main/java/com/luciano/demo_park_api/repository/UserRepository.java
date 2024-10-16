package com.luciano.demo_park_api.repository;

import com.luciano.demo_park_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}