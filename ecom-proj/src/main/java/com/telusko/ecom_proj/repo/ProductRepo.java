package com.telusko.ecom_proj.repo;

import com.telusko.ecom_proj.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// so in the type we added 2 fields one is class-which is also the table name, we are working with and other is primary key

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    List<Product> findAll();  // Basic method to fetch all products

}
