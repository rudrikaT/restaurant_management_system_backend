package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Restaurant;
import com.example.demo.entity.RestaurantCategory;
import com.example.demo.service.ServiceImplementations;

@RestController
@RequestMapping("restaurantcategory")
public class RestaurantCategoryController {
	private ServiceImplementations serimp;
	
	@Autowired
	public RestaurantCategoryController(ServiceImplementations serimp) {
		
		this.serimp = serimp;
	}

	@GetMapping("/list")
	public List<RestaurantCategory> displayAllRest(){
		List<RestaurantCategory> restList = serimp.displayAllRestCategory();
 		
		return restList;
	}

	@GetMapping("list/{id}")
	public RestaurantCategory displayById(@PathVariable("id") int id) {
		RestaurantCategory rest = serimp.getRestaurantCategoryById(id);
		if(rest==null) {
			throw new RuntimeException("Restaurant not found with this Id");
		}
		return rest;
	}


	@PostMapping("/list")
	public void insertRestaurantCategory(@RequestBody RestaurantCategory rest) {
		serimp.insertRestaurantCategory(rest);
	}

	@PutMapping("/list")
	public void updateRestaurantCategory(@RequestBody RestaurantCategory rest) {
		serimp.updateRestaurantCategory(rest);
	}
	
	@DeleteMapping("/list/{id}")
	public void DeleteRestCategory(@PathVariable("id") int id) {
		serimp.deleteRestCategory(id);
	}
	
	@GetMapping("list3/{rcname}")
	public List<Restaurant> search(@PathVariable("rcname") String name)
	{
		return serimp.searchByRestCat(name);
	}
	
}
