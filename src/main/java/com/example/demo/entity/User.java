package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="uid")
	private int uid;
	
	@Column(name="uname")
	private String uname;
	
	@Column(name="uaddress")
	private String uaddress;
	
	@Column(name="uemail")
	private String uemail;
	
	@Column(name="upass")
	private String upassword;
	
	@Column(name="SecurityQuestion")
	private String securityQuestion;
	
	@Column(name="SecurityAnswer")
	private String securityAnswer;
	
	@OneToMany(mappedBy = "user")
	private List<Booking> bookings;

	
	public User() {
		
	}
	

	public User(int uid, String uname, String uaddress, String uemail, String upassword, String securityQuestion,
			String securityAnswer, List<Booking> bookings) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uaddress = uaddress;
		this.uemail = uemail;
		this.upassword = upassword;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.bookings = bookings;
	}



	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	@JsonIgnore
	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	
	public String getUemail() {
		return uemail;
	}


	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	
	public String getSecurityQuestion() {
		return securityQuestion;
	}


	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}


	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	
	
}
