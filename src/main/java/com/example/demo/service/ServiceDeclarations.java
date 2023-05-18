package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Restaurant;
import com.example.demo.entity.RestaurantCategory;
import com.example.demo.entity.User;

public interface ServiceDeclarations {

	public List<Restaurant> displayAllRest();
	public Restaurant getRestaurantById(int id);
	public void insertRestaurant(Restaurant restaurant);
	public void deleteRest(int id);
	public List<Restaurant> sortBasedOnRating(String order);
	public Restaurant searchByName(String rname);
	public Restaurant searchByLocation(String rlocation);
	public void updateRestaurant(Restaurant restaurant);
	
	public List<RestaurantCategory> displayAllRestCategory();
	public RestaurantCategory getRestaurantCategoryById(int id);
	public void insertRestaurantCategory(RestaurantCategory restaurantCategory);
	public void deleteRestCategory(int id);
	public void updateRestaurantCategory(RestaurantCategory restaurantCategory);
	
	public List<Booking> getAllBookings();
	public Booking getBookingById(int bid);
	public Booking addBooking(Booking booking);
	public Booking updateBooking(Booking booking);
	public void deleteBooking(int bid);
	public void updateSeats(Booking booking);

	
	public List<User> getAllUser();
	public User getUserById(int uid);
	public User addUser(User user);
	public User updateUser(User user);
	public void deleteUser(int bid);
	public List<Restaurant> searchByRestCat(String name);
	public List<Booking> bookingsByRest(int id);
	public List<Booking> bookingsByUser(int id);
	public boolean userExists(String email);
	public List<Restaurant> searchBySeats(int seatsavailable);
	public User getByemail(String email);
	
	
	public double getRating(int id);
	public void updateRating(Booking book);
	public User getUserByEmail(String email);
	public List<User> getAllUserByName(String name);
	
	public User enuser(String uemail,String upass);
//	public User loadUserByUsername(String username); //throws UsernameNotFoundException;
	//public boolean validateUser(String username, String password);
	
}
