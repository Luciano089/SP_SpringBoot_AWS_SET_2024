package models.dao;

import models.entities.Department;
import models.entities.Seller;

import java.util.List;

public interface SellerDao {
    void update(Seller obj);
    void insert(Seller obj);
    void deleteById(Integer id);
    Seller findById(Integer id);
    List<Seller> findAll();
}
