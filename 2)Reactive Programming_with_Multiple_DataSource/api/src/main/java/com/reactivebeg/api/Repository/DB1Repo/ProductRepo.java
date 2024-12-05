package com.reactivebeg.api.Repository.DB1Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reactivebeg.api.Entity.DB1Entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}