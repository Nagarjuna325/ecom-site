package com.telusko.ecom_proj.controller;


import com.telusko.ecom_proj.model.Product;
import com.telusko.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

     @Autowired
     private ProductService service;

    @RequestMapping("/home")
    public String greet(){
        return "Hello World";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){

        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);

    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {

        //return service.getProductById(id);
        Product product = service.getProduct(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
