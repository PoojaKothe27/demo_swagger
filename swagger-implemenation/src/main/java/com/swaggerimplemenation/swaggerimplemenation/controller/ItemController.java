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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Item Resource to handle all Item related action and queries ")
@RequestMapping("/items")
public class ItemController {
	@Autowired
	private ItemService service;

	@GetMapping("/")
	@ApiOperation(value = "Return all Items available in the System", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "Requested Resource Not Found") })
	public ResponseEntity<List<ItemDto>> fetchItems(@) {
		List<ItemDto> items = service.fetchAll();
		return new ResponseEntity<List<ItemDto>>(items, HttpStatus.OK);
	}

	@ApiOperation(value = "Return Item for provided Id", response = ItemDto.class)
	@GetMapping("/{id}")
	public ResponseEntity<ItemDto> fetchItemById(@PathVariable long id) {
		ItemDto ItemDto = service.fetchById(id);
		return new ResponseEntity<ItemDto>(ItemDto, HttpStatus.OK);
	}

	@PostMapping("/")
	@ApiOperation(value = "Create the Item based on input provided", response = ItemDto.class)
	public ResponseEntity<ItemDto> create(@RequestBody ItemDto dto) {
		ItemDto ItemDto = service.create(dto);
		return new ResponseEntity<ItemDto>(ItemDto, HttpStatus.OK);
	}

	@ApiOperation(value = "Updated Item for provided Id and with updated details", response = ItemDto.class)
	@PutMapping("/{id}")
	public ResponseEntity<ItemDto> update(@PathVariable Long id, @RequestBody ItemDto dto) {
		ItemDto itemDto = service.update(dto);
		return new ResponseEntity<ItemDto>(itemDto, HttpStatus.OK);
	}

	@ApiOperation(value = "Approves the Item for provided Id", response = ItemDto.class)
	@PatchMapping("/{id}")
	public ResponseEntity<ItemDto> approve(@PathVariable Long id) {
		return null;
	}

	@ApiOperation(value = "Delete the Item from System for provided Id", response = ItemDto.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<String>("Item has been deleted", HttpStatus.OK);
	}
}
