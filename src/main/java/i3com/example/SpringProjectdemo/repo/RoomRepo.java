
















































package i3com.example.SpringProjectdemo.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import i3com.example.SpringProjectdemo.entities.Room;

//Performing CRUD Operations
public interface RoomRepo extends JpaRepository<Room, Integer> {

//3 retrieve all the entities where given roomType is matched
	List<Room> findByRoomtype(String roomtype);
	
	
	/*4
	 * retrieve all the entities where given room type and bed type and status are
	 * matched
	 */
	@Query("FROM Room WHERE roomtype=:a and bedtype=:b and statusofroom=:c ")
	List<Room> getRooms(@Param("a") String a, @Param("b") String b, @Param("c") String c);

//	@Query(value = "SELECT COUNT(r.roomnumber) FROM room r  WHERE r.roomtype = 'executive' AND r.statusofroom = 'Available'   AND  not EXISTS (SELECT b.roomnumber FROM bookinghistory b  WHERE b.startdate='1/9/23'  AND b.enddate='1/10/23')", nativeQuery = true)
//	int co();

	/*11
	 * retrieve number of rooms available for given room type and status and bed
	 * type from given date to given date matched
	 */
	@Query(value = "SELECT COUNT(*) as available FROM room r  WHERE r.roomtype = :a AND r.statusofroom = :b and bedtype=:c  AND  not EXISTS (SELECT * FROM upcomingbooking b  WHERE b.startdate between :d  AND :e)", nativeQuery = true)
	int countAvailableRooms(@Param("a") String roomType, @Param("b") String status, @Param("c") String bedtype,
			@Param("d") LocalDate startDate, @Param("e") LocalDate endDate);
}
