package com.shop.pet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.shop.pet.dto.Product;

@Mapper
public interface ProductDao {
    List<Product> getAllProducts();
    
    List<Product> getProductsByCategory(String prodClass);
}
