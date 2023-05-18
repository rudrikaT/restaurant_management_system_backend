package com.example.demo.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Restaurant;
import com.example.demo.entity.RestaurantCategory;
import com.example.demo.entity.User;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.RestaurantCategoryRepository;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.repository.UserRepository;

@Service
public class ServiceImplementations implements ServiceDeclarations {

	private RestaurantRepository rrep;
	private RestaurantCategoryRepository rcrep;
	private BookingRepository bookrep;
	private UserRepository urep;
	
	@Autowired
	public ServiceImplementations(RestaurantRepository rrep,RestaurantCategoryRepository rcrep,BookingRepository bookrep,UserRepository urep) {
		this.rrep = rrep;
		this.rcrep = rcrep;
		this.bookrep = bookrep;
		this.urep = urep;
	}

	@Override
	@Transactional
	public List<Restaurant> displayAllRest() {
		// TODO Auto-generated method stub
		return rrep.findAll();
	}

	
	@Override
	@Transactional
	public Restaurant getRestaurantById(int id) {
		// TODO Auto-generated method stub
		return rrep.findById(id).get();
	}

	
	@Override
	@Transactional
	public void insertRestaurant(Restaurant restaurant) {
		rrep.save(restaurant);
		
	}
	
	@Override
	@Transactional
	public void deleteRest(int id) {
		rrep.deleteById(id);
		
	}

	@Override
	@Transactional
	public List<RestaurantCategory> displayAllRestCategory() {
		// TODO Auto-generated method stub
		return rcrep.findAll();
	}

	@Override
	@Transactional
	public RestaurantCategory getRestaurantCategoryById(int id) {
		// TODO Auto-generated method stub
		return rcrep.findById(id).get();
	}

	@Override
	@Transactional
	public void insertRestaurantCategory(RestaurantCategory restaurantCategory) {
		// TODO Auto-generated method stub
		rcrep.save(restaurantCategory);
	}

	@Override
	@Transactional
	public void deleteRestCategory(int id) {
		// TODO Auto-generated method stub
		rcrep.deleteById(id);
	}
	
	@Override
	@Transactional
    public List<Booking> getAllBookings() {
        return bookrep.findAll();
    }

	@Override
	@Transactional
    public Booking getBookingById(int bid) {
        return bookrep.findById(bid).orElse(null);
    }

	@Override
	@Transactional
    public Booking addBooking(Booking booking) {
		int rid = booking.getRid();
		Restaurant rest = rrep.findById(rid).get() ;
	    int seatsToBeBooked = booking.getSeatstobebooked();
	    int availableSeats = rest.getSeatsavailable();
	    if (seatsToBeBooked > availableSeats) {
	        throw new RuntimeException("Booking cannot be completed. Insufficient seats available.");
	    }
	    else {
        return bookrep.save(booking);
	    }
	}
    
	@Override
	@Transactional
    public Booking updateBooking(Booking booking) {
		int rid = booking.getRid();
		Restaurant rest = rrep.findById(rid).get() ;
	    int seatsToBeBooked = booking.getSeatstobebooked();
	    int availableSeats = rest.getSeatsavailable();
	    if (seatsToBeBooked > availableSeats) {
	        throw new RuntimeException("Booking cannot be completed. Insufficient seats available.");
	    }
	    else {
        return bookrep.save(booking);
	    }
    }

	@Override
	@Transactional
    public void deleteBooking(int bid) {
        Booking existingBooking = bookrep.findById(bid).orElse(null);
        if(existingBooking == null) {
            return;
        }
        bookrep.delete(existingBooking);
    }

	@Override
	@Transactional
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return urep.findAll();
	}

	@Override
	@Transactional
	public User getUserById(int uid) {
		// TODO Auto-generated method stub
		return urep.findById(uid).get();
	}

	@Override
	@Transactional
	public User addUser(User user) {
		String upass = user.getUpassword();
		byte[] enc = Base64.getEncoder().encode(upass.getBytes());
		String pass = new String(enc);
		user.setUpassword(pass);
		return urep.save(user);
	}

	@Override
	@Transactional
	public User updateUser(User user) {
		String upass = user.getUpassword();
		byte[] enc = Base64.getEncoder().encode(upass.getBytes());
		String pass = new String(enc);
		user.setUpassword(pass);
		return urep.save(user);
	}

	@Override
	@Transactional
	public void deleteUser(int uid) {
		// TODO Auto-generated method stub
		urep.deleteById(uid);
	}

	@Override
	@Transactional
	public List<Restaurant> sortBasedOnRating(String order) {
		// TODO Auto-generated method stub
		if(order.equalsIgnoreCase("HightoLow")) {
			return rrep.highToLow();
		}
		else if(order.equalsIgnoreCase("LowtoHigh")) {
			return rrep.lowToHigh();
		}
		return rrep.findAll();
		
	}

	
		@Override
		@Transactional
		public List<Restaurant> searchByRestCat(String name) {
		// TODO Auto-generated method stub
			List<RestaurantCategory> res=rcrep.searchByRestCat(name);
			List<Restaurant> rlist = new ArrayList<Restaurant>();
			for(RestaurantCategory rc : res) {
				rlist.addAll(rc.getRestaurants());
			}
			return rlist;
	}

	@Override	
	@Transactional
	public List<Booking> bookingsByRest(int id) {
		// TODO Auto-generated method stub
		return bookrep.bookingByRest(id);
	}
	
	@Override
	@Transactional
	public Restaurant searchByName(String rname) {
		return rrep.searchRestaurant(rname);
	}
//Service Implementation
	@Override
	@Transactional
	public Restaurant searchByLocation(String rlocation) {
		return rrep.searchRestByLoc(rlocation);
	}
	
	@Override
	@Transactional
	public boolean userExists(String email) {
        return urep.findByEmail(email) != null;
    }

	@Override
	@Transactional
	public List<Booking> bookingsByUser(int id) {
		// TODO Auto-generated method stub
		return bookrep.bookingByUser(id);
	}  
	
	@Override
	@Transactional
	public List<Restaurant> searchBySeats(int seatsavailable) {
		// TODO Auto-generated method stub
		return rrep.findByAvailableSeats(seatsavailable);
    }

	@Override
	@Transactional
	public User getByemail(String email) {
		// TODO Auto-generated method stub
		return urep.findByEmail(email);
	}
	
	
	@Override
	@Transactional
	public void updateSeats(Booking book) {
		// TODO Auto-generated method stu
		int rid = book.getRid();
		Restaurant rest = rrep.findById(rid).get();
		int totalseats = rest.getSeatsavailable();
		int seatsleft= totalseats-book.getSeatstobebooked();
		bookrep.updateSeats(seatsleft, rest.getRid());
	}
	

	@Override
	@Transactional
	public void updateRating(Booking book) {
		int rid = book.getRid();
		Restaurant rest = rrep.findById(rid).get();
		double rat = bookrep.getRating(rid); 
		bookrep.updateRating(rat, rest.getRid());
	}
	
	@Override
	@Transactional
	public void updateRestaurantCategory(RestaurantCategory restaurantCategory) {
		rcrep.save(restaurantCategory);
		
	}

	@Override
	@Transactional
	public void updateRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		rrep.save(restaurant);
	}

	@Override
	@Transactional
	public double getRating(int id) {
		
		return bookrep.getRating(id);
	}
	
	@Override
	@Transactional
	public User getUserByEmail(String email) {
		
		return urep.findByEmail(email);
	}
	
	@Override
	@Transactional
	public List<User> getAllUserByName(String name) {
		// TODO Auto-generated method stub
		return urep.findByUsername(name);
	}
	
	
	@Override
	@Transactional
	public User enuser(String uemail,String upass) {
		byte[] enc = Base64.getEncoder().encode(upass.getBytes());
		String pass = new String(enc);
		//user.setUpassword(pass);
		User user1 = urep.findByEmail(uemail);
		if(user1==null) {
			return null;
		}
		else if(user1.getUpassword()==null) {
			return null;
		}
		else if(user1.getUpassword().equals(pass)) {
			return user1;
		}
		else {
			return null;
		}
		
	}
	
	// public User loadUserByUsername(String username) { //throws UsernameNotFoundException {
	       // User user = urep.findByUsername(username);

	       /* if (user == null) {
	            throw new UsernameNotFoundException("Invalid username or password.");
	        }*/

	      //  return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
	            //    new ArrayList<>());
	//  }
}
