package com.example.demo.entity;
import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.JsonSerializable;

@Entity
@Table(name = "booking")
public class Booking implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;

	@Column(name = "rid")
	private int rid;
	
	@ManyToOne(targetEntity = Restaurant.class,fetch = FetchType.EAGER)
	@JoinColumn(name="rid",insertable = false,updatable = false)
	private Restaurant restaurant;

	@Column(name = "uid")
	private int uid;

	@ManyToOne(targetEntity = User.class ,fetch = FetchType.EAGER)
	@JoinColumn(name = "uid",insertable = false,updatable = false)
	private User user;

	@Column(name ="starttime")
	private LocalDateTime startTime;

	@Column(name ="endtime")
	private LocalDateTime endTime;
	
	@Column(name="seatstobebooked")
	private int seatstobebooked;
	
	@Column(name="rating")
	private double rating;

	public Booking(int bid, int rid, int uid, LocalDateTime startTime, LocalDateTime endTime, int seatstobebooked,
			int rating) {
		super();
		this.bid = bid;
		this.rid = rid;
		this.uid = uid;
		this.startTime = startTime;
		this.endTime = endTime;
		this.seatstobebooked = seatstobebooked;
		this.rating = rating;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public int getSeatstobebooked() {
		return seatstobebooked;
	}

	public void setSeatstobebooked(int seatstobebooked) {
		this.seatstobebooked = seatstobebooked;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	

	@Override
	public String toString() {
		return "Booking [bid=" + bid + ", rid=" + rid + ", uid=" + uid + ", startTime=" + startTime + ", endTime="
				+ endTime + ", seatstobebooked=" + seatstobebooked + ", rating=" + rating + "]";
	}


}
