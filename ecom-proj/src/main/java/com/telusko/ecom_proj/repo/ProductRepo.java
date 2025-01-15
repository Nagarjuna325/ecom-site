package com.telusko.ecom_proj.repo;

import com.telusko.ecom_proj.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// so in the type we added 2 fields one is class-which is also the table name, we are working with and other is primary key

@Repository
public  interface ProductRepo extends JpaRepository<Product, Integer> {

    List<Product> findAll();  // Basic method to fetch all products
    //JPQL -JPA query language - same as SQL in SQL table names here classnames, columns names in SQL , field names in JPQL

    @Query("SELECT p from Product p WHERE " + // JPQL QUERY
            "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Product> searchProducts(String keyword);

}
