package com.reactivebeg.api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactivebeg.api.Entity.DB1Entity.Product;
import com.reactivebeg.api.Repository.DB1Repo.ProductRepo;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public Product createProduct(Product data) {

        return productRepo.save(data);

    }

    public Product updateProduct(int id, Product data) {

        Product product = productRepo.findById(id).orElse(null);
        if (product == null) {
            return null;
        }
        product.setName(data.getName());
        product.setPrice(data.getPrice());
        productRepo.save(product);
        return product;

    }

    public List<Product> getAllProduct() {

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
