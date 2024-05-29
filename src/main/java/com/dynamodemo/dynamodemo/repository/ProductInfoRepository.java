package com.dynamodemo.dynamodemo.repository;

import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.dynamodemo.dynamodemo.model.ProductInfo;

@EnableScan
public interface ProductInfoRepository extends 
  CrudRepository<ProductInfo, String> {
    
    Optional<ProductInfo> findById(String id);
}
