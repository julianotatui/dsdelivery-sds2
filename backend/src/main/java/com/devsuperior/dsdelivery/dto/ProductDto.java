package com.devsuperior.dsdelivery.dto;

import java.io.Serializable;

import com.devsuperior.dsdelivery.entities.Product;

public class ProductDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private double price;
	private String description;
	private String imageUri;
	
	public ProductDto() {
		
	}
	
	public ProductDto(long id, String name, double price, String description, String imageUri) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imageUri = imageUri;
	}
	
	public ProductDto(Product entity) {
		id = entity.GetId();
		name = entity.GetName();
		price = entity.GetPrice();
		description = entity.GetDescription();
		imageUri = entity.GetImageUri();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}
	
	
	

}
