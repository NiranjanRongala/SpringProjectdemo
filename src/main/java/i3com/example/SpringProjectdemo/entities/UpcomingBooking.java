package i3com.example.SpringProjectdemo.entities;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//UpcomingBooking entity mapping to upcomingbooking table in the database
@Entity
@Table(name = "upcomingbooking")
public class UpcomingBooking {

	// columns in bookinghistory table

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "upbookid")
	private int upbookid;

	@Column(name = "startdate")
	private Date startdate;

	@Column(name = "roomtype")
	private String roomtype;

	@Column(name = "bedtype")
	private String bedtype;

	@Column(name = "numberofrooms")
	private int numberofrooms;

	// ManyToOne relation with Customer entity
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "custid")
	// @JsonIgnore
	private Customer customer;

	// Setter and getter methods
	public int getUpbookid() {
		return upbookid;
	}

	public void setUpbookid(int upbookid) {
		this.upbookid = upbookid;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
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

	public int getNumberofrooms() {
		return numberofrooms;
	}

	public void setNumberofrooms(int numberofrooms) {
		this.numberofrooms = numberofrooms;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bedtype, customer, numberofrooms, roomtype, startdate, upbookid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UpcomingBooking other = (UpcomingBooking) obj;
		return Objects.equals(bedtype, other.bedtype) && Objects.equals(customer, other.customer)
				&& numberofrooms == other.numberofrooms && Objects.equals(roomtype, other.roomtype)
				&& Objects.equals(startdate, other.startdate) && upbookid == other.upbookid;
	}

	@Override
	public String toString() {
		return "UpcomingBooking [upbookid=" + upbookid + ", startdate=" + startdate + ", roomtype=" + roomtype
				+ ", bedtype=" + bedtype + ", numberofrooms=" + numberofrooms + ", customer=" + customer + "]";
	}

}
