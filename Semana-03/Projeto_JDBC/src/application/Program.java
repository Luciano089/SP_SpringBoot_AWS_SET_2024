package application;

import models.dao.DaoFactory;
import models.dao.SellerDao;
import models.entities.Department;
import models.entities.Seller;

import java.util.List;

import java.util.Date;
import java.util.List;


public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> listSeller = sellerDao.findByDepartment(department);
        for (Seller obj : listSeller) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: seller findAll ===");
        listSeller = sellerDao.findAll();
        for (Seller obj : listSeller) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 4: seller Insert ===");
        Seller newSeller = new Seller(null, "greg", "greg@gmail.com", new Date(), 4000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("Insert New id: " + newSeller.getId());
    }

}

