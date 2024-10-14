package com.example.springCourse.Repositories;

import com.example.springCourse.Entities.OrderItem;
import com.example.springCourse.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
