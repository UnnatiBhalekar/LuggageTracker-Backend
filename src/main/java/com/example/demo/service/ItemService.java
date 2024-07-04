package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Item;

import com.example.demo.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	// create an item
	public Item createItem(Item item) {
		return itemRepository.save(item);
	}

	// get all items
	public List<Item> getAllItems() {
		return itemRepository.findAll();

	}

	// get item by id
	public Optional<Item> getItemById(int item_id) {
		return itemRepository.findById(item_id);
	}

	// update item by id
	public Item updateItemById(int id, Item updated_item) {

		Optional<Item> existing_item = itemRepository.findById(id);
		if (existing_item.isPresent()) {
			Item item = existing_item.get();
			item.setItem_name(updated_item.getItem_name());
			item.setWeight(updated_item.getWeight());
			item.setQuantity(updated_item.getQuantity());
			return itemRepository.save(item);
		} else {
			throw new RuntimeException("Item not found");
		}

	}

	// delete item by id
	public void deleteItemById(int item_id) {
		itemRepository.deleteById(item_id);

	}

	// delete all items
	public void deleteAllItems() {
		itemRepository.deleteAll();
	}
}
