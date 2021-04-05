package com.swaggerimplemenation.swaggerimplemenation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.swaggerimplemenation.swaggerimplemenation.entity.ItemDto;

@Service
public class ItemService {
	List<ItemDto> items = new ArrayList<>();

	public List<ItemDto> fetchAll() {
		return items;
	}

	public ItemDto fetchById(long id) {
		return items.stream().filter(dto -> dto.getId() == id).collect(Collectors.toList()).get(0);
	}

	public ItemDto create(ItemDto dto) {
		items.add(dto);
		return dto;
	}

	public ItemDto update(ItemDto dto) {
		items.add(dto);
		items.forEach(dto1 -> {
			if (dto1.getId() == dto.getId()) {
				dto1.setItemCode(dto.getItemCode());
				dto1.setItemDescription(dto.getItemDescription());
				dto1.setPrice(dto.getPrice());
			}
		});
		return dto;
	}

	public void delete(long id) {
		items.removeIf(dto -> dto.getId() == id);
	}
}
