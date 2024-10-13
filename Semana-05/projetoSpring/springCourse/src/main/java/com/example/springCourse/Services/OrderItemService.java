package com.example.springCourse.Services;

import com.example.springCourse.Entities.Order;
import com.example.springCourse.Entities.OrderItem;
import com.example.springCourse.Entities.User;
import com.example.springCourse.Repositories.OrderItemRepository;
import com.example.springCourse.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository repository;

    public List<OrderItem> findAll() {
        return repository.findAll();
    }

    public OrderItem FindById(Long id){
         Optional<OrderItem> obj = Optional.of(repository.findById(id).get());
         return obj.get();
    }
}
