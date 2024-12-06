package com.reactivebeg.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactivebeg.api.Entity.DB1Entity.Product;
import com.reactivebeg.api.Repository.DB1Repo.ProductRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public Mono<Product> createProduct(Product data) {

        return productRepo.save(data);

    }

    public Mono<Product> updateProduct(int id, Product data) {

        return productRepo.findById(id).flatMap(product -> {
            product.setName(data.getName());
            product.setPrice(data.getPrice());
            return productRepo.save(product);
        }).switchIfEmpty(null);
    }

    public Flux<Product> getAllProduct() {

        return productRepo.findAll();

    }

    public String deleteProduct(int id) {

        try {
            productRepo.deleteById(id);
            return "Product Deleted Successfully";
        } catch (Exception e) {
            return "Product Not Found";
        }
    }

}
