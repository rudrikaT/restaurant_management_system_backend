package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Restaurant;
import com.example.demo.entity.RestaurantCategory;

public interface RestaurantCategoryRepository extends JpaRepository<RestaurantCategory, Integer> {

	@Query("from RestaurantCategory where rcname=?1")
	public List<RestaurantCategory> searchByRestCat(String name);
	

}
