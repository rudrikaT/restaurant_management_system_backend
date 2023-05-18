package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	
	@Query("from Restaurant order by rating asc")
	public List<Restaurant> lowToHigh();
	
	@Query("from Restaurant order by rating desc")
	public List<Restaurant> highToLow();
		
	@Query("from Restaurant where rname like %?%1")
	public Restaurant searchRestaurant(String rname);

	@Query("from Restaurant where rlocation=?1")
	public Restaurant searchRestByLoc(String rlocation);

	@Query("FROM Restaurant WHERE seatsavailable >= ?1")
	public List<Restaurant> findByAvailableSeats(int seatsavailable);
	
}
