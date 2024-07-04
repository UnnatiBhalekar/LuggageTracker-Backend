package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	/**
     * Create a new item.
     * @param item the item to create
     * @return the ResponseEntity with status 200 (OK) and with body of the new item
     */
	@PostMapping("/item")
	public ResponseEntity<Item> addItem(@RequestBody Item item){
		Item item_added = itemService.createItem(item);
		return ResponseEntity.ok(item_added);
		
	}
	
	/**
     * Get all items.
     */
	@GetMapping("/allItems")
	public List<Item> readAllItems(){
		return itemService.getAllItems();
	}
	
	/**
	 * Get item by id
	 * @return the ResponseEntity with status 200 (OK) and with body of the item, 
	 * or with status 404 (Not Found) if the item does not exist
	 */
	@GetMapping("/item/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable int id){
		Item item = itemService.getItemById(id);
        if (item != null) {
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
	}
	
//	/**
//     * Update a item by ID.
//     *
//     * @param id the ID of the item to update
//     * @param item the updated item
//     * @return the ResponseEntity with status 200 (OK) and with body of the updated product, or with status 404 (Not Found) if the product does not exist
//     */
//	@GetMapping("/item/{id}")
//	public ResponseEntity<Item> updateItem(@PathVariable int id){
//		return null;
//	}
	
	
	

}
