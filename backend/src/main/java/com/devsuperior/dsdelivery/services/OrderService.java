package com.devsuperior.dsdelivery.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdelivery.dto.OrderDto;
import com.devsuperior.dsdelivery.dto.ProductDto;
import com.devsuperior.dsdelivery.entities.Order;
import com.devsuperior.dsdelivery.entities.OrderStatus;
import com.devsuperior.dsdelivery.entities.Product;
import com.devsuperior.dsdelivery.repositories.OrderRepository;
import com.devsuperior.dsdelivery.repositories.ProductRepository;

@Service
public class OrderService {

	private static long xId ;
	
	@Autowired
	private OrderRepository repository;

	@Autowired
	private ProductRepository productRepository;

	
	@Transactional (readOnly = true)  // garante que o banco será apenas lido
	public List<OrderDto> findAll(){
		
      List<Order> list = repository.findOrderWithProducts();
	  return list.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());
	}
	
	@Transactional   
	public OrderDto insert(OrderDto dto){
      
      //Cria o Pedido com os dados básicos em uma nova instância, com o objetivo de aramzenar no banco de dados.
	  Order order = new Order(xId, dto.getAddress(), dto.getLatitude(), dto.getLongitude(),Instant.now(),OrderStatus.PENDING);
	  // Cria os produtos nos pedidos na nova instância, com o objetivo de aramzenar no banco de dados.
	  for (ProductDto p : dto.getProducts()) {
		  Product product =  productRepository.getOne(p.getId()); //Cria a relação Ordem X Pedido
		  order.GetProducts().add(product); // Adiciona os produtos na Instância product
	  }
	  
	  order = repository.save(order);
	  return new OrderDto(order);
	  
	  
	}
}
