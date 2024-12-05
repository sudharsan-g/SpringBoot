package com.reactivebeg.api.Controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactivebeg.api.Entity.DB1Entity.Product;
import com.reactivebeg.api.Service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/product/")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("create")
    public ResponseEntity<?> createProduct(@RequestBody Product data) {

        try {
            return new ResponseEntity<>(productService.createProduct(data), HttpStatusCode.valueOf(201));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(500));
        }

    }

    @GetMapping("getall")
    public ResponseEntity<?> getMethodName() {
        try {
            return new ResponseEntity<>(productService.getAllProduct(), HttpStatusCode.valueOf(200));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(500));
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable int id, @RequestBody Product data) {
        try {
            return new ResponseEntity<>(productService.updateProduct(id, data), HttpStatusCode.valueOf(200));
        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error", HttpStatusCode.valueOf(500));
        }

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteMapping(@PathVariable int id) {
        try {
            return new ResponseEntity<>(productService.deleteProduct(id), HttpStatusCode.valueOf(200));
        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error", HttpStatusCode.valueOf(500));
        }

    }

}
