package com.app.pojos;


import java.util.Date;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="STOCKDETAILS")
public class Stockdetail  
{
	
	private Integer stockId;

    private Integer consumer;

    private Integer domestic;
	private Date date;

	public Stockdetail() 
	{
		System.out.println("in stock dtail..ctr");
	}
	public Stockdetail(Integer consumer, Integer domestic, Date date) {
		super();
		this.consumer = consumer;
		this.domestic = domestic;
		this.date = date;
	}
	
	
	public Stockdetail(Integer stockId, Integer consumer, Integer domestic, Date date) {
		super();
		this.stockId = stockId;
		this.consumer = consumer;
		this.domestic = domestic;
		this.date = date;
	}

	@Id
	@GeneratedValue
	@Column(name="StockId")
	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	@Column(name="Consumer")
	public Integer getConsumer() {
		return this.consumer;
	}

	public void setConsumer(Integer consumer) {
		this.consumer = consumer;
	}

	@Column(name="Domestic")
	public Integer getDomestic() {
		return this.domestic;
	}

	public void setDomestic(Integer domestic) {
		this.domestic = domestic;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="Date")
	public Date getDate() {
		return date;
	}
    public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Stockdetail [stockId=" + stockId + ", consumer=" + consumer + ", domestic=" + domestic + ", date="
				+ date + "]";
	}
    
    



}