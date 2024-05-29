package com.dynamodemo.dynamodemo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dynamodemo.dynamodemo.model.ProductInfo;
import com.dynamodemo.dynamodemo.repository.ProductInfoRepository;

@RestController
@RequestMapping("/api/products")
public class ProductInfoController {
    @Autowired
    ProductInfoRepository productInfoRepository;

    @GetMapping("/{id}")
    public Optional<ProductInfo> getProductById(@PathVariable String id) {
        return productInfoRepository.findById(id);
    }

    @PostMapping
    public ProductInfo createProduct(@RequestBody ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @PutMapping("/{id}")
    public ProductInfo updateProduct(@PathVariable String id, @RequestBody ProductInfo productInfo) {
        if (productInfoRepository.existsById(id)) {
            productInfo.setId(id);
            return productInfoRepository.save(productInfo);
        } else {
            throw new RuntimeException("Product with ID " + id + " not found");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productInfoRepository.deleteById(id);
    }
}