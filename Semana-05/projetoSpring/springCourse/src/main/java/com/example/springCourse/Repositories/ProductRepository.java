package com.example.springCourse.Repositories;

import com.example.springCourse.Entities.Category;
import com.example.springCourse.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
