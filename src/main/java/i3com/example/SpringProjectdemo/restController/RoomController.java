package i3com.example.SpringProjectdemo.restController;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import i3com.example.SpringProjectdemo.entities.BookingHistory;
import i3com.example.SpringProjectdemo.entities.Room;
import i3com.example.SpringProjectdemo.repo.BookingHistoryRepo;
import i3com.example.SpringProjectdemo.repo.RoomRepo;
import io.swagger.v3.oas.annotations.Operation;

@RestController // create Restful web services using Spring MVC
public class RoomController {

	@Autowired // inject dependencies automatically
	private RoomRepo roomRepo;
	@Autowired // inject dependencies automatically
	private BookingHistoryRepo bookingHistoryRepo;

	// 1 List of rooms
	@GetMapping("/listOfRooms")
	@Operation(summary = "Get list of all rooms")
	public List<Room> getAll1() {
		return roomRepo.findAll();
	}

	// 3 List of rooms by room type
	@GetMapping("/roomsbyroomtype/{roomtype}")
	@Operation(summary = "Get rooms by room type")
	public List<Room> getAll5(@PathVariable("roomtype") String roomtype) {
		return roomRepo.findByRoomtype(roomtype);
	}

	// 4 List of rooms by room type, bed type, status
	@GetMapping("/roomsby/{roomtype}/{bedtype}/{status}")
	@Operation(summary = "Get rooms by room type and bed type and status(Available or Occupied) ")
	public List<Room> getAll6(@PathVariable("roomtype") String a, @PathVariable("bedtype") String b,
			@PathVariable("status") String c) {
		return roomRepo.getRooms(a, b, c);

	}

	// 9 Change the status of a room by room number
	@PutMapping("/changestatus/{roomno}/{status}")
	@Operation(summary = "Update room status by room number and status ")
	public Room updateProd(@PathVariable("roomno") int num, @PathVariable("status") String statusofroom) {

		var room = roomRepo.findById(num);
		if (room.isPresent()) {
			var r = room.get();
			r.setStatusofroom(statusofroom);
			roomRepo.save(r);
			return r;

		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "room number Not Found");
	}

	// 10 Handle check out by room number and update room status
	@PostMapping("/insertandupdate/{roomnumber}/{status}")
	@Operation(summary = "take room number and add new row to bookinghistory and also update room status ")
	public BookingHistory insert(@PathVariable("roomnumber") int roomnumber, @PathVariable("status") String status,
			@RequestBody BookingHistory bookinghistory) {
		var rooms = roomRepo.findById(roomnumber);
		if (rooms.isPresent()) {
			Room room = rooms.get();
			room.setStatusofroom(status);
			roomRepo.save(room);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "room not found");
		}

		bookingHistoryRepo.save(bookinghistory);
		return bookinghistory;
	}

	// 11 count rooms by room type, status ,start date and end date
	@GetMapping("/countAvailableRooms/{roomType}/{status}/{bedtype}/{startDate}/{endDate}")
	@Operation(summary = "Count number of rooms available by room type, status ,start date and end date ")
	public int availbleRoomsGivenTimePeriod(@PathVariable String roomType, @PathVariable String status,
			@PathVariable String bedtype, @PathVariable LocalDate startDate, @PathVariable LocalDate endDate) {
		return roomRepo.countAvailableRooms(roomType, status, bedtype, startDate, endDate);
	}

}
