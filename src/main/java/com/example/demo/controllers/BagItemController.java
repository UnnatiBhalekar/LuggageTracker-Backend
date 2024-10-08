package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.BagItemDTO;

import com.example.demo.entity.BagWeightAndSpaceDTO;
import com.example.demo.service.BagItemService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") 
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
	public ResponseEntity<BagItemDTO> addItemToBag(@PathVariable int bagId, @PathVariable int itemId) {
		try {
			BagItemDTO bagItemDTO = bagItemService.addItemToBag(bagId, itemId);
			return ResponseEntity.status(HttpStatus.OK).body(bagItemDTO);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
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
	public ResponseEntity<List<Map<String, Object>>> getItemsByBagId(@PathVariable int bagId) {
		List<Map<String, Object>> itemsInBag = bagItemService.itemsinEachBag(bagId);
		if(itemsInBag.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(itemsInBag);
	}

	/**
	 * Retrieves the total weight and available space in a specified bag based on
	 * the given bagId.
	 * 
	 * @param bagId The ID of the bag.
	 * @return ResponseEntity with BagWeightAndSpaceDTO containing total weight and
	 *         available space.
	 */
	@GetMapping("/weight/space/{bagId}")
	public ResponseEntity<BagWeightAndSpaceDTO> getWeightAndAvailableSpace(@PathVariable int bagId) {
		BagWeightAndSpaceDTO bagWeightAndSpace = bagItemService.getWeightAndAvailableSpace(bagId);
		return ResponseEntity.ok(bagWeightAndSpace);
	}
	
	/**
	 * Deletes the item in a specified bag based on
	 * the given bagId and itemId.
	 * 
	 * @param bagId The ID of the bag, itemId which is ID of the item
	 * @return ResponseEntity : Item from the particular bag is deleted
	 */
	@DeleteMapping("/{bagId}/items/{itemName}")
	public ResponseEntity<String> deleteItemFromBag(@PathVariable int bagId, @PathVariable String itemName){
		bagItemService.deleteItemFromBag(bagId, itemName);
		return ResponseEntity.ok("Item deleted successfully from Bag "+bagId);
	}
}
