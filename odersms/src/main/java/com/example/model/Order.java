package com.example.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection="sgorders")
public class Order {

	@Id
	private int id;

	private String name;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date orderDate;

	private Boolean active;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int id, String name, Date orderDate, Boolean active) {
		this.id = id;
		this.name = name;
		this.orderDate = orderDate;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
