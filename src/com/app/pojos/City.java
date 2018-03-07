package com.app.pojos;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="CITY")
public class City 
{

	private Integer cityId;
	private String cityName;
	private Integer pinCode;
	private List<Customer> customers =new ArrayList<>();

	
	
	public City() 
	{
		System.out.println("in city cunstr....");
	}
	public City(String cityName, Integer pinCode, List<Customer> customers) {
		
		this.cityName = cityName;
		this.pinCode = pinCode;
		this.customers = customers;
	}

   public City(int cityId, String cityName, Integer pinCode, List<Customer> customers) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.pinCode = pinCode;
		this.customers = customers;
	}




    @Id
    @GeneratedValue
    @Column(name="CityId")
	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
    
	@Column(name="CityName")
	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	@Column(name="PinCode")
	public Integer getPinCode() {
		return this.pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}
    
	@OneToMany(cascade=CascadeType.ALL,mappedBy="city")
	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + ", pinCode=" + pinCode ;
	}
	
	

}