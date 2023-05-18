package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	@Modifying
	@Query("update Restaurant set seatsavailable=?1 where rid=?2")
	public void updateSeats(int seats,int id);
	
	@Query("from Booking where rid=?1")
	public List<Booking> bookingByRest(int id);
	
	@Query("from Booking where uid=?1")
	public List<Booking> bookingByUser(int id);

	//@Modifying
	
	@Query(value="Select avg(rating) from Booking where rid=:rid",nativeQuery = true)
	public double getRating(@Param("rid") int rid);
	
	@Modifying
	@Query("update Restaurant set rating=?1 where rid=?2")
	public void updateRating(double rating, int id);

	
	
} 
