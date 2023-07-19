package i3com.example.SpringProjectdemo.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//Room entity mapping to room table in the database
@Entity
@Table(name = "room")
public class Room {

	// columns in room table

	@Id
	@Column(name = "roomnumber")
	private int roomnumber;

	@Column(name = "floornum")
	private int floornum;

	@Column(name = "roomtype")
	private String roomtype;

	@Column(name = "bedtype")
	private String bedtype;

	@Column(name = "tariff")
	private Double tariff;

	@Column(name = "statusofroom")
	private String statusofroom;

	/*
	 * One to many relation with booking history entity and mapped with room entity
	 * ----- And mappedBy = attribute indicates that which entity owns the
	 * relationship
	 */

	@OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
	@JsonIgnore // ignore the property from serialization
	private List<BookingHistory> bookinghistories = new ArrayList<BookingHistory>();

	// Setter and getter methods
	public int getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(int roomnumber) {
		this.roomnumber = roomnumber;
	}

	public int getFloornum() {
		return floornum;
	}

	public void setFloornum(int floornum) {
		this.floornum = floornum;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getBedtype() {
		return bedtype;
	}

	public void setBedtype(String bedtype) {
		this.bedtype = bedtype;
	}

	public Double getTariff() {
		return tariff;
	}

	public void setTariff(Double tariff) {
		this.tariff = tariff;
	}

	public String getStatusofroom() {
		return statusofroom;
	}

	public void setStatusofroom(String statusofroom) {
		this.statusofroom = statusofroom;
	}

	public List<BookingHistory> getBookinghistories() {
		return bookinghistories;
	}

	public void setBookinghistories(List<BookingHistory> bookinghistories) {
		this.bookinghistories = bookinghistories;
	}

	// hashCode method
	@Override
	public int hashCode() {
		return Objects.hash(bedtype, bookinghistories, floornum, roomnumber, roomtype, statusofroom, tariff);
	}

	// equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return Objects.equals(bedtype, other.bedtype) && Objects.equals(bookinghistories, other.bookinghistories)
				&& floornum == other.floornum && roomnumber == other.roomnumber
				&& Objects.equals(roomtype, other.roomtype) && Objects.equals(statusofroom, other.statusofroom)
				&& Objects.equals(tariff, other.tariff);
	}

	// toString method
	@Override
	public String toString() {
		return "Room [roomnumber=" + roomnumber + ", floornum=" + floornum + ", roomtype=" + roomtype + ", bedtype="
				+ bedtype + ", tariff=" + tariff + ", statusofroom=" + statusofroom + ", bookinghistories="
				+ bookinghistories + "]";
	}

}