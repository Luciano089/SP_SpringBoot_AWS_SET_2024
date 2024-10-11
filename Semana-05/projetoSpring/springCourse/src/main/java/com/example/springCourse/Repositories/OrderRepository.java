package com.example.springCourse.Repositories;

import com.example.springCourse.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderRepository extends JpaRepository<Order, Long> {

}
