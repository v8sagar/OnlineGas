package com.app.pojos;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="BOOKING")

public class Booking 
{

	
	private Integer bookingId;
    private Date bookingDate;
    private String status;
    private Customer customer;
 
	public Booking()
	{
		System.out.println("in booking cstr..");
	}
 
	
	public Booking(Date bookingDate, String status, Customer customer) {
		super();
		
		this.bookingDate = bookingDate;
		this.status = status;
		this.customer = customer;
	}



	
	public Booking(Integer bookingId, Date bookingDate, String status, Customer customer) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.status = status;
		this.customer = customer;
	}




	@Id
	@GeneratedValue
	@Column(name="BookingId")
	public Integer getBookingId() {
		return this.bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
    
	@Temporal(TemporalType.DATE)
	@Column(name="BookingDate")
	public Date getBookingDate() {
		return this.bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
   
	@Column(name="Status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CustomerID")
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", status=" + status + ", customer="
				+ customer + "]";
	}
	
	
	

}