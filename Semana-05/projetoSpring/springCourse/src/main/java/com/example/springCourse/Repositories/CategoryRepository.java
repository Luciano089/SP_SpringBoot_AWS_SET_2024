package com.example.springCourse.Repositories;

import com.example.springCourse.Entities.Category;
import com.example.springCourse.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
