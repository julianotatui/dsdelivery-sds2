package com.devsuperior.dsdelivery.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* @Entity - Configuração para que os objetos possam ser convertidos para o banco de dados relacional pela ferramenta ORM JPA. */
@Entity
@Table (name = "tb_product") /* estamos dizendo que a classe product é correspondente a tablea tb_product */
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/* vai mapear o atributo id como uma chave primária autoincremental na tabela tb_product */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private double price;
	private String description;
	private String imageUri;

    
public Product() {
	
}

public Product(long id, String name, double price, String description, String imageUri ){
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.description = description;
	this.imageUri = imageUri;
}

public void SetId(long id) {
	this.id = id;
}

public void SetName(String name) {
	this.name = name;
}

public void SetPrice(double price) {
	this.price = price;
}

public void SetDescription(String description) {
	this.description = description;
}

public void SetImageUri(String imageUri) {
	this.imageUri = imageUri;
}

public long GetId() {
	return id;
}

public String GetName() {
	return name;
}

public double GetPrice() {
	return price;
}


public String GetDescription() {
	return description;
}

public String GetImageUri() {
	return imageUri;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (id ^ (id >>> 32));
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Product other = (Product) obj;
	if (id != other.id)
		return false;
	return true;
}



}
