package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("from User where uemail=?1")
	public User findByEmail(String uemail);
//
//	@Query("from User where uname=?1")
//	public User findByUsername(String username);

	@Query("FROM User WHERE LOWER(uname) LIKE LOWER(concat('%', :username, '%'))")
	public List<User> findByUsername(@Param("username") String username);

//	public List<Booking> findByUserId(Long userId);
}
