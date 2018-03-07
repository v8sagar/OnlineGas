package com.app.pojos;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="CUSTOMERS")
public class Customer  
{
	private Integer customerId;
	private String firstname;
	private String lastname;
	private String address;
	private String gender;
	private Date dob;
	private String mobileno;
    private String email;
	private String connectiontype;
    private String usertype;
	private String password;
	private Double deposit;
	
	private City city;
	private List<Booking> bookings =new ArrayList<>();
	private String securityQuaston;
	private String securityAns;
	
	
	public Customer()
    {
		System.out.println("in customer ctr...");
	}
	

	public Customer(String firstname, String lastname, String address, String gender, Date dob,
			String mobileno, String email, String connectiontype, String usertype, String password, Double deposit,
			City city, List<Booking> bookings,String securityQuaston,String securityAns) {
		super();
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.gender = gender;
		this.dob = dob;
		this.mobileno = mobileno;
		this.email = email;
		this.connectiontype = connectiontype;
		this.usertype = usertype;
		this.password = password;
		this.deposit = deposit;
		this.city = city;
		this.bookings = bookings;
		this.securityQuaston=securityQuaston;
		this.securityAns=securityAns;
	}
	
	public Customer(Integer customerId, String firstname, String lastname, String address, String gender, Date dob,
			String mobileno, String email, String connectiontype, String usertype, String password, Double deposit,
			City city, List<Booking> bookings,String securityQuaston,String securityAns) {
		super();
		this.customerId = customerId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.gender = gender;
		this.dob = dob;
		this.mobileno = mobileno;
		this.email = email;
		this.connectiontype = connectiontype;
		this.usertype = usertype;
		this.password = password;
		this.deposit = deposit;
		this.city = city;
		this.bookings = bookings;
		this.securityQuaston=securityQuaston;
		this.securityAns=securityAns;
	}
	
	
	@Id
	@GeneratedValue
	@Column(name="CustomerId")
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
	
	@Column(name="FirstName")
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	
	@Column(name="LastName")
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Column(name="Address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="Gender")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="DOB")
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	@Column(name="MobileNo", unique = true)
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	
	@Column(name="Email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="ConnectionType")
	public String getConnectiontype() {
		return connectiontype;
	}
	public void setConnectiontype(String connectiontype) {
		this.connectiontype = connectiontype;
	}
	
	@Column(name="UserType")
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	@Column(name="Password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="Deposit")
	public Double getDeposit() {
		return deposit;
	}
	public void setDeposit(Double deposit) 
	{
		this.deposit =  deposit;
	}
	@ManyToOne
	@JoinColumn(name="CityId")
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customer")
	public List<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	public String getSecurityQuaston() {
		return securityQuaston;
	}

	public void setSecurityQuaston(String securityQuaston) {
		this.securityQuaston = securityQuaston;
	}


	public String getSecurityAns() {
		return securityAns;
	}


	public void setSecurityAns(String securityAns) {
		this.securityAns = securityAns;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", address=" + address + ", gender=" + gender + ", dob=" + dob + ", mobileno=" + mobileno + ", email="
				+ email + ", connectiontype=" + connectiontype + ", usertype=" + usertype + "  deposit=" + deposit ;
	}
	

}