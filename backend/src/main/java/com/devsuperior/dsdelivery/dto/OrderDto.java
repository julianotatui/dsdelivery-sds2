package com.devsuperior.dsdelivery.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

import com.devsuperior.dsdelivery.entities.Order;
import com.devsuperior.dsdelivery.entities.OrderStatus;


public class OrderDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String address;
	private double latitude;
	private double longitude;
	private Instant moment;
	private OrderStatus status;
	
	private List<ProductDto> products = new ArrayList<>();
	
	public OrderDto() {
		
	}
		
	
	public OrderDto(long id, String address, double latitude, double longitude, Instant moment, OrderStatus status) {
		this.id = id;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moment = moment;
		this.status = status;
	}

	
	public OrderDto(Order entity) {
		id = entity.getId();
		address = entity.getAddress();
		latitude = entity.getLatitude();
		longitude = entity.getLongitude();
		moment = entity.GetMoment();
		status = entity.GetStatus();
		products = entity.GetProducts().stream().map(x -> new ProductDto(x)).collect(Collectors.toList());
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public Instant getMoment() {
		return moment;
	}


	public void setMoment(Instant moment) {
		this.moment = moment;
	}


	public OrderStatus getStatus() {
		return status;
	}


	public void setStatus(OrderStatus status) {
		this.status = status;
	}


	public List<ProductDto> getProducts() {
		return products;
	}



	

}
