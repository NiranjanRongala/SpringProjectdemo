package i3com.example.SpringProjectdemo.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//Customer entity mapping to customer table in the database
@Entity
@Table(name = "customer")
public class Customer {

	// columns in customers table

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "custid")
	private int custid;

	@Column(name = "names")
	private String names;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "gender")
	private String gender;

	/*
	 * One to many relation with BookingHistory entity and mapped with Customer
	 * entity ----- And mappedBy = attribute indicates that which entity owns the
	 * relationship
	 */
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	@JsonIgnore // ignore infinity recursion
	private List<BookingHistory> bookinghistories = new ArrayList<BookingHistory>();

	/*
	 * one to many relation with UpcomingBooking entity and mapped with Customer
	 * entity ----- And mappedBy = attribute indicates that which entity owns the
	 * relationship
	 */
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	@JsonIgnore // ignore the property from serialization
	private List<UpcomingBooking> upcomingbookings = new ArrayList<UpcomingBooking>();

	// Setter and getter methods

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<BookingHistory> getBookinghistories() {
		return bookinghistories;
	}

	public void setBookinghistories(List<BookingHistory> bookinghistories) {
		this.bookinghistories = bookinghistories;
	}

	public List<UpcomingBooking> getUpcomingbookings() {
		return upcomingbookings;
	}

	public void setUpcomingbookings(List<UpcomingBooking> upcomingbookings) {
		this.upcomingbookings = upcomingbookings;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookinghistories, custid, email, gender, mobile, names, upcomingbookings);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(bookinghistories, other.bookinghistories) && custid == other.custid
				&& Objects.equals(email, other.email) && Objects.equals(gender, other.gender)
				&& Objects.equals(mobile, other.mobile) && Objects.equals(names, other.names)
				&& Objects.equals(upcomingbookings, other.upcomingbookings);
	}

	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", names=" + names + ", email=" + email + ", mobile=" + mobile
				+ ", gender=" + gender + ", bookinghistories=" + bookinghistories + ", upcomingbookings="
				+ upcomingbookings + "]";
	}

}