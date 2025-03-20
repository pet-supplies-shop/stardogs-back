package com.shop.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.pet.dto.Product;
import com.shop.pet.dao.ProductDao;

@Service
public class ProductService {
	@Autowired
    private ProductDao productDao;

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    public List<Product> getProductsByClass(String prodClass) {
        return productDao.getProductsByCategory(prodClass);
    }
}
