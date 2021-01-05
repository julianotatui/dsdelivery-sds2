package com.devsuperior.dsdelivery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsdelivery.dto.OrderDto;
import com.devsuperior.dsdelivery.services.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<OrderDto>> findAll(){
		List<OrderDto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
