package com.turkcell.spring_starter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.spring_starter.model.Product;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    // In-Memory 
    private List<Product> productList = new ArrayList<>();

    @GetMapping()
    public List<Product> getAll() {
        return productList;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping()
    public void createProduct(@RequestBody Product product) {
        productList.add(product);
    }

    @PutMapping
    public void updateProduct(@RequestBody Product product) {

        Product existingProduct = productList.stream()
                .filter(p -> p.getId() == product.getId())
                .findFirst()
                .orElseThrow();

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());        
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productList.removeIf(p -> p.getId() == id);
    }
        
}
