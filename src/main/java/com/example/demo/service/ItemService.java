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
	
	//create an item
	public Item createItem(Item item) {
		return itemRepository.save(item);
	}
	
	//get all items
	public List<Item> getAllItems(){
		return itemRepository.findAll();
		
	}
	
	//get item by id
	public Item getItemById(Integer item_id) {
		Optional<Item> item = itemRepository.findById(item_id);
		if(item.isPresent()) {
			return item.get();
		}
		throw new RuntimeException("Item not Found with ID "+item_id);
	}
	
	//update item by id
	public Item updateItembyId(Item updated_item) {
		return itemRepository.save(updated_item);
	}
	
	//delete item by id
	public void deleteItemById(Integer item_id) {
		Optional<Item> item = itemRepository.findById(item_id);
		if(item.isPresent()) {
			itemRepository.deleteById(item_id);
		}
		throw new RuntimeException("Item not Found with ID "+item_id);
	}
	
	//delete all items 
	public void deleteAllItems() {
		itemRepository.deleteAll();
	}
}
