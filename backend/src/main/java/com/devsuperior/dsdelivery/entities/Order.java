package com.devsuperior.dsdelivery.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/* @Entity - Configuração para que os objetos possam ser convertidos para o banco de dados relacional pela ferramenta ORM JPA. */
@Entity
@Table (name = "tb_order") /* estamos dizendo que a classe order é correspondente a tablea tb_order */
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/* vai mapear o atributo id como uma chave primária autoincremental na tabela tb_product */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String address;
	private double latitude;
	private double longitude;
	private Instant moment;
	private OrderStatus status;
	
	/* A lista foi substituida pela coleção Set pois essa coleção garante a não repetição e cria no banco a tabela de associação */
	/* @ManyToMany - referencia o products a tabela tb_order_product e o @JoinTable monta a composta que é a chave estrangeira da tablea tb_order e tb_product */
	@ManyToMany
	@JoinTable(name = "tb_order_product",
	           joinColumns = @JoinColumn(name = "order_id"),
	           inverseJoinColumns = @JoinColumn(name = "product_id")
	)
	private Set<Product> products = new HashSet<>();
	
	public Order() {
		
	}
	
	public Order(long id, String address, double latitude, double longitude, Instant moment, OrderStatus status) {
		super();
		this.id = id;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moment = moment;
		this.status    = status;
		
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
	
	public Instant GetMoment() {
		return moment;
	}
	
	public void SetMoment(Instant moment) {
		this.moment = moment;
	}
	
	
	public OrderStatus GetStatus() {
		return status;
	}
	
	public void SetStatus(OrderStatus status) {
		this.status = status;
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
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	

}
