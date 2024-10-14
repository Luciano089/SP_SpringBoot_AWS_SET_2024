package com.example.springCourse.Services;

import com.example.springCourse.Entities.Product;
import com.example.springCourse.Entities.User;
import com.example.springCourse.Repositories.ProductRepository;
import com.example.springCourse.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product FindById(Long id){
         Optional<Product> obj = Optional.of(repository.findById(id).get());
         return obj.get();
    }
}
