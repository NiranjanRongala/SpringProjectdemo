package i3com.example.SpringProjectdemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import i3com.example.SpringProjectdemo.entities.UpcomingBooking;

//Performing CRUD Operations
public interface UpcomingBookingRepo extends JpaRepository<UpcomingBooking, Integer> {

	List<UpcomingBooking> findByCustomer_Custid(int custid);

}
