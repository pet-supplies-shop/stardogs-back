package com.shop.pet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.pet.dto.Product;
import com.shop.pet.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin("http://127.0.0.1:5500/")
public class ProductController {
	@Autowired
    private ProductService productService;

    // 전체 상품 조회
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // 특정 prodClass에 해당하는 상품 조회
    @GetMapping("/class/{prodClass}")
    public List<Product> getProductsByClass(@PathVariable String prodClass) {
    	System.out.println(prodClass);
        return productService.getProductsByClass(prodClass);
    }
}
