package com.pankaja.project1.controller;

import com.pankaja.project1.model.Product;
import com.pankaja.project1.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/helloworld")
    public ResponseEntity<CsrfToken> greeting(HttpServletRequest http) {

        return new ResponseEntity<>((CsrfToken) http.getAttribute("_csrf"), HttpStatus.FOUND);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {

        return new ResponseEntity<>(service.getAllProducts(),HttpStatus.OK);
    }
    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product prod){

        try {

            return new ResponseEntity<>(service.addProduct(prod),HttpStatus.OK);
            
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id){
        return service.getProductByID(id);
    }
}
