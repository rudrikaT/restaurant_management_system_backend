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
import com.example.demo.entity.RestaurantCategory;
import com.example.demo.service.ServiceImplementations;

@RestController
@RequestMapping("booking")
public class BookingController {

	private ServiceImplementations serimp;
	
	@Autowired
	public BookingController(ServiceImplementations serimp) {
		this.serimp = serimp;
	}

	@GetMapping("/list")
	public List<Booking> displayAllRest(){
		List<Booking> restList = serimp.getAllBookings();
		return restList;
	}

	@GetMapping("list/{id}")
	public Booking displayById(@PathVariable("id") int id) {
		Booking rest = serimp.getBookingById(id);
		if(rest==null) {
			throw new RuntimeException("Restaurant not found with this Id");
		}
		return rest;
	}


	@PostMapping("/list")
	public void insertBooking(@RequestBody Booking book) {
		serimp.addBooking(book);
		serimp.updateSeats(book);
	}

	@DeleteMapping("/list/{id}")
	public void DeleteBooking(@PathVariable("id") int id) {
		serimp.deleteBooking(id);
	}
	
	@GetMapping("list1/{rid}")
	public List<Booking> searchByRest(@PathVariable("rid") int id)
	{
		return serimp.bookingsByRest(id);
	}
	
	@GetMapping("list2/{uid}")
	public List<Booking> searchByUser(@PathVariable("uid") int id)
	{
		return serimp.bookingsByUser(id);
	}
	
	@PutMapping("/list")
	public void updateBooking(@RequestBody Booking book) {
		serimp.updateBooking(book);
		serimp.updateRating(book);
	}
	
	
}
