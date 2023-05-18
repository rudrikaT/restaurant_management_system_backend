package com.example.demo.controller;

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

import com.example.demo.entity.Booking;
import com.example.demo.entity.Restaurant;
import com.example.demo.service.ServiceImplementations;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {

	private ServiceImplementations serimp;
	
	@Autowired
	public RestaurantController(ServiceImplementations serimp) {
		
		this.serimp = serimp;
	}

	@GetMapping("/list")
	public List<Restaurant> displayAllRest(){
		List<Restaurant> restList = serimp.displayAllRest();
 		
		return restList;
	}

	@GetMapping("list/{id}")
	public Restaurant displayById(@PathVariable("id") int id) {
		Restaurant rest = serimp.getRestaurantById(id);
		if(rest==null) {
			throw new RuntimeException("Restaurant not found with this Id");
		}
		return rest;
	}


	@PostMapping("/list")
	public void insertRestaurant(@RequestBody Restaurant rest) {
		serimp.insertRestaurant(rest);
	}
	
	@PutMapping("/list")
	public void updateRestaurant(@RequestBody Restaurant rest) {
		serimp.insertRestaurant(rest);
	}

	@DeleteMapping("/list/{id}")
	public void deleteRest(@PathVariable("id") int id) {
		serimp.deleteRest(id);
	}
	
	@GetMapping("/slist/{order}")
	public List<Restaurant> displayBasedOnRating(@PathVariable("order") String order){
		List<Restaurant> restList = serimp.sortBasedOnRating(order);
		return restList;
	}
	
	@GetMapping("/list1/{rname}")
	public Restaurant getRestaurantByName(@PathVariable("rname") String rname){
			String resname = rname;
			resname.replace(" ","%20");
			return serimp.searchByName(resname);
		}
		
	@GetMapping("/list2/{rlocation}")
	public Restaurant getRestaurantByLocation(@PathVariable("rlocation") String rlocation){
			return serimp.searchByLocation(rlocation);
		}
	
	@GetMapping("list3/{seats}")
	public List<Restaurant> search(@PathVariable("seats") int seats)
	{
		List<Restaurant> res=serimp.searchBySeats(seats);
		return res;
	}
	
	
}
