package i3com.example.SpringProjectdemo.entities;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//BookingHistory entity mapping to bookinghistory table in the database
@Entity
@Table(name = "bookinghistory")
public class BookingHistory {

	// columns in bookinghistory table
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookid")
	private int bookid;

	@Column(name = "startdate")
	private Date startdate;

	@Column(name = "enddate")
	private Date enddate;

	private int custid;

	// ManyToOne relation with Customer entity
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "custid", updatable = false, insertable = false)
	@JsonIgnore
	private Customer customer;

	private int roomnumber;

	// ManyToOne relation with Room entity
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roomnumber", updatable = false, insertable = false)
	@JsonIgnore
	private Room room;

	// Setter and getter methods

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public int getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(int roomnumber) {
		this.roomnumber = roomnumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookid, custid, customer, enddate, room, roomnumber, startdate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingHistory other = (BookingHistory) obj;
		return bookid == other.bookid && custid == other.custid && Objects.equals(customer, other.customer)
				&& Objects.equals(enddate, other.enddate) && Objects.equals(room, other.room)
				&& roomnumber == other.roomnumber && Objects.equals(startdate, other.startdate);
	}

	@Override
	public String toString() {
		return "BookingHistory [bookid=" + bookid + ", startdate=" + startdate + ", enddate=" + enddate + ", custid="
				+ custid + ", customer=" + customer + ", roomnumber=" + roomnumber + ", room=" + room + "]";
	}
	

}
