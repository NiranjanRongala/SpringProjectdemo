package i3com.example.SpringProjectdemo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import i3com.example.SpringProjectdemo.entities.BookingHistory;
import i3com.example.SpringProjectdemo.repo.BookingHistoryRepo;
import io.swagger.v3.oas.annotations.Operation;

@RestController // create Restful web services using Spring MVC
public class BookingHistoryController {
	@Autowired // inject dependencies automatically
	private BookingHistoryRepo bookingHistoryRepo;

	// 7 Booking history of a customer
	@GetMapping("/bookingHistoryOf/{customerid}")
	@Operation(summary = "Get Booking history of a customer by customer id")
	public List<BookingHistory> getall8(@PathVariable("customerid") int id) {
		return bookingHistoryRepo.findByCustomer_Custid(id);
	}

	// 8 Add new row to booking histories table
	@PostMapping("/newbookinghistoryy")
	@Operation(summary = "Add a new Booking History")
	public BookingHistory addPro1(@RequestBody BookingHistory bookingHistory) {
		try {
			bookingHistoryRepo.save(bookingHistory);
			return bookingHistory;
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid data");
		}
	}
}
