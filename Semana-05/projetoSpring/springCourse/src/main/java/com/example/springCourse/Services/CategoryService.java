package com.example.springCourse.Services;

import com.example.springCourse.Entities.Category;
import com.example.springCourse.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }


    public Category FindById(Long id) {
        Optional<Category> obj = Optional.of(repository.findById(id).get());
        return obj.get();
    }
}
