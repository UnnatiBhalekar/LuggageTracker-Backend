package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BagItem;
import com.example.demo.service.BagItemService;

@RestController
@RequestMapping("/api")
public class BagItemController {

	@Autowired
	private BagItemService bagItemService;

	/**
	 * Adds an item to a bag.
	 * 
	 * This method handles the POST request to add an item to a specified bag.
	 * 
	 * @param bagId  The ID of the bag to which the item should be added.
	 * @param itemId The ID of the item to be added to the bag.
	 * @return A ResponseEntity with a success message if the item is added
	 *         successfully, or an error message if the bag or item is not found.
	 */
	@PostMapping("/add/{bagId}/{itemId}")
	public ResponseEntity<String> addItemToBag(@PathVariable int bagId, @PathVariable int itemId) {
		try {
			BagItem bagItem = bagItemService.addItemToBag(bagId, itemId);
			return ResponseEntity.status(HttpStatus.OK).body("Item Added Successfully");
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	/**
	 * Retrieves all items in a specified bag based on the given bagId. Returns a
	 * list of Object arrays where each array contains itemName and weight.
	 *
	 * @param bagId The ID of the bag for which items are to be retrieved.
	 * @return ResponseEntity with a list of Object arrays containing item details
	 *         or a 404 status if no items are found.
	 */
	@GetMapping("/bag/items/{bagId}")
	public ResponseEntity<List<Object[]>> getItemsByBagId(@PathVariable int bagId) {
		List<Object[]> itemsInBag = bagItemService.itemsinEachBag(bagId);
		if (itemsInBag.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(itemsInBag);
	}

}