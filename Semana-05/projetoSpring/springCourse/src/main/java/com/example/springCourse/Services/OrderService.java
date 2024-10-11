package com.example.springCourse.Services;

import com.example.springCourse.Entities.Order;
import com.example.springCourse.Entities.User;
import com.example.springCourse.Repositories.OrderRepository;
import com.example.springCourse.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order FindById(Long id){
         Optional<Order> obj = repository.findById(id);
         return obj.get();
    }
}
