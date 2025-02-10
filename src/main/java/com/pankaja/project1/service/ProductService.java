package com.pankaja.project1.service;

import com.pankaja.project1.model.Product;
import com.pankaja.project1.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepo repo;

    public ProductService(ProductRepo repo) {
        this.repo = repo;
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product addProduct(Product prod) {
        return repo.save(prod);
    }

    public Product getProductByID(int id) {
        return repo.findById(id).orElse(new Product());
    }
}
