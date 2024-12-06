package com.reactivebeg.api.Repository.DB1Repo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.reactivebeg.api.Entity.DB1Entity.Product;

@Repository
public interface ProductRepo extends R2dbcRepository<Product, Integer> {

}