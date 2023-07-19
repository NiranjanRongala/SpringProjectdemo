package i3com.example.SpringProjectdemo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import i3com.example.SpringProjectdemo.entities.UpcomingBooking;
import i3com.example.SpringProjectdemo.repo.UpcomingBookingRepo;
import io.swagger.v3.oas.annotations.Operation;

@RestController // create Restful web services using Spring MVC
public class UpcomingBookingController {
	@Autowired // inject dependencies automatically
	private UpcomingBookingRepo upcomingBookingRepo;

	// 5 List of Upcoming Bookings
	@GetMapping("/upcomingbookinglist")
	@Operation(summary = "Get Upcoming Bookings list")
	public List<UpcomingBooking> getAll3() {
		return upcomingBookingRepo.findAll();
	}

	// 6 List of upcoming bookings of a single customer
	@GetMapping("/upcomingbookingby/{custid}")
	@Operation(summary = "Get upcoming Bookings Of a customer by customer id")
	public List<UpcomingBooking> getAll7(@PathVariable("custid") int id) {
		return upcomingBookingRepo.findByCustomer_Custid(id);

	}
}
