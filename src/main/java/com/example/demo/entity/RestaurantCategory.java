package com.example.demo.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "restaurant_category")
public class RestaurantCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rcid")
    private int rcid;

    @Column(name="rcname")
    private String rcname;

    @OneToMany(mappedBy = "restaurantCategory")
    private List<Restaurant> restaurants;

	public RestaurantCategory(int rcid, String rcname) {
		super();
		this.rcid = rcid;
		this.rcname = rcname;
	}

	public RestaurantCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRcid() {
		return rcid;
	}

	public void setRcid(int rcid) {
		this.rcid = rcid;
	}

	public String getRcname() {
		return rcname;
	}

	public void setRcname(String rcname) {
		this.rcname = rcname;
	}
	@JsonIgnore
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
    
    // Constructors, getters, and setters
}