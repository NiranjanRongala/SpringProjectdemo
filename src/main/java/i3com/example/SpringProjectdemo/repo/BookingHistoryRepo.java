package i3com.example.SpringProjectdemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import i3com.example.SpringProjectdemo.entities.BookingHistory;

//Performing CRUD Operations
public interface BookingHistoryRepo extends JpaRepository<BookingHistory, Integer> {

	// retrieve all the entities where given CustomerId is matched
	List<BookingHistory> findByCustomer_Custid(int custid);
}
