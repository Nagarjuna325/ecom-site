package com.telusko.ecom_proj.service;


import com.telusko.ecom_proj.model.Product;
import com.telusko.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
         // we are getting product from controller which it got from client and we will sent it to repo to store in
        // database , but we also need to send the image and need to store it in the database , which we need to convert
        // to bytes and store in the database.
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());

         return  repo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {

        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }
}


