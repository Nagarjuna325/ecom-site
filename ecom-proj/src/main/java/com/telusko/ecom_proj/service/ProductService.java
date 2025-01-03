package com.telusko.ecom_proj.service;


import com.telusko.ecom_proj.model.Product;
import com.telusko.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

     //object of product repo created
    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts() {

           return repo.findAll();

//         List<Product> products = repo.findAll();
//         System.out.println("Products: " + products);
//         return products;
    }

//    public Product getProductById(int id) {
//
//        return repo.findById(id).get();
//    }

    public Product getProduct(int id) {
        return repo.findById(id).orElse(null);
    }
}


