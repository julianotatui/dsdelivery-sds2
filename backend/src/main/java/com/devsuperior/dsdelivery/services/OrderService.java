package com.devsuperior.dsdelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdelivery.dto.OrderDto;
import com.devsuperior.dsdelivery.entities.Order;
import com.devsuperior.dsdelivery.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Transactional (readOnly = true)  // garante o fechamento da conexão com o banco
	public List<OrderDto> findAll(){
		
      List<Order> list = repository.findOrderWithProducts();
	  return list.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());
	}
}
