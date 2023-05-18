package com.example.demo.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rid")
    private int rid;

    @Column(name="rname")
    private String rname;

    @Column(name="rlocation")
    private String rlocation;

    @Column(name="rcontactno")
    private String rcontactno;
    
    @Column(name="image")
    private String image;
    
    @Column(name="rating")
    private double rating;
    
    @Column(name="totalseats")
    private int totalseats;
    
    @Column(name="seatsavailable")
    private int seatsavailable;

    @Column(name="rcid")
    private int rcid;
    
    @ManyToOne(targetEntity = RestaurantCategory.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "rcid",insertable = false,updatable = false)
    private RestaurantCategory restaurantCategory;

    @OneToMany(mappedBy = "restaurant")
    private List<Booking> bookings;
    

	public Restaurant(int rid, String rname, String rlocation, String rcontactno, String image, double rating,
			int totalseats, int seatsavailable, int rcid) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.rlocation = rlocation;
		this.rcontactno = rcontactno;
		this.image = image;
		this.rating = rating;
		this.totalseats = totalseats;
		this.seatsavailable = seatsavailable;
		this.rcid = rcid;
	}
	
	public int getRcid() {
		return rcid;
	}

	public void setRcid(int rcid) {
		this.rcid = rcid;
	}

	public int getTotalseats() {
		return totalseats;
	}


	public void setTotalseats(int totalseats) {
		this.totalseats = totalseats;
	}
    public int getSeatsavailable() {
		return seatsavailable;
	}

	public void setSeatsavailable(int seatsavailable) {
		this.seatsavailable = seatsavailable;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Restaurant() {
		
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRlocation() {
		return rlocation;
	}

	public void setRlocation(String rlocation) {
		this.rlocation = rlocation;
	}

	public String getRcontactno() {
		return rcontactno;
	}

	public void setRcontactno(String rcontactno) {
		this.rcontactno = rcontactno;
	}



	@Override
	public String toString() {
		return "Restaurant [rid=" + rid + ", rname=" + rname + ", rlocation=" + rlocation + ", rcontactno=" + rcontactno
				+ "]";
	}

	
    // Constructors, getters, and setters
}
