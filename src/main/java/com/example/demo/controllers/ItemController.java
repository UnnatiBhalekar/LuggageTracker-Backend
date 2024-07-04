package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	/**
	 * Create a new item.
	 * 
	 * @param item the item to create
	 * @return the ResponseEntity with status 200 (OK) and with body of the new item
	 */
	@PostMapping("/item")
	public ResponseEntity<Item> addItem(@RequestBody Item item) {
		Item item_added = itemService.createItem(item);
		return ResponseEntity.ok(item_added);

	}

	/**
	 * Get all items.
	 */
	@GetMapping("/allItems")
	public List<Item> readAllItems() {
		return itemService.getAllItems();
	}

	/**
	 * Get item by id
	 * 
	 * @return the ResponseEntity with status 200 (OK) and with body of the item, or
	 *         with status 404 (Not Found) if the item does not exist
	 */
	@GetMapping("/item/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable int id) {
		Optional<Item> item = itemService.getItemById(id);
		return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	/**
	 * Update a item by ID.
	 *
	 * @param id   the ID of the item to update
	 * @param item the updated item
	 * @return the ResponseEntity with status 200 (OK) and with body of the updated
	 *         item, or with status 404 (Not Found) if the item does not exist
	 */
	@PutMapping("/item/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable int id, @RequestBody Item item) {
		Item updatedItem = itemService.updateItemById(id, item);
		return ResponseEntity.ok(updatedItem);
	}

	/**
	 * Delete a item by ID.
	 *
	 * @param id the ID of the item to delete
	 * @return the ResponseEntity with status 200 (OK) and with body of the message
	 *         "item deleted successfully"
	 */
	@DeleteMapping("/item/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable int id) {
		itemService.deleteItemById(id);
		return ResponseEntity.ok("item deleted successfully");
	}

	/**
	 * Delete all items
	 * 
	 * @return the ResponseEntity with status 200 (OK) and with body of the message
	 *         "Product deleted successfully"
	 */
	@DeleteMapping("/items")
	public ResponseEntity<String> deleteAllItem() {
		itemService.deleteAllItems();
		return ResponseEntity.ok("All items deleted successfully");
	}

}
