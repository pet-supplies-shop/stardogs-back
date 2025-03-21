package com.shop.pet.dao;

import org.apache.ibatis.annotations.Mapper;
import com.shop.pet.dto.Pet;

@Mapper
public interface PetDao {
	public void insertPet(Pet p) throws Exception;
}
