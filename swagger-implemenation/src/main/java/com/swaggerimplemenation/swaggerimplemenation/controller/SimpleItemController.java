package com.swaggerimplemenation.swaggerimplemenation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swaggerimplemenation.swaggerimplemenation.entity.ItemDto;
import com.swaggerimplemenation.swaggerimplemenation.service.ItemService;

@RestController
@RequestMapping("/simpleItem")
public class SimpleItemController {
	@Autowired
	private ItemService service;
	
	@GetMapping("/")
	public ResponseEntity<List<ItemDto>> fetchItems() {
		List<ItemDto> items = service.fetchAll();
		return new ResponseEntity<List<ItemDto>>(items, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemDto> fetchItemById(@PathVariable long id) {
		ItemDto ItemDto = service.fetchById(id);
		return new ResponseEntity<ItemDto>(ItemDto, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<ItemDto> create(@RequestBody ItemDto dto) {
		ItemDto ItemDto = service.create(dto);
		return new ResponseEntity<ItemDto>(ItemDto, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ItemDto> update(@PathVariable Long id, @RequestBody ItemDto dto) {
		ItemDto itemDto = service.update(dto);
		return new ResponseEntity<ItemDto>(itemDto, HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<ItemDto> approve(@PathVariable Long id) {
		return null;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<String>("Item has been deleted", HttpStatus.OK);
	}
}
