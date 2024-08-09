package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Bag;
import com.example.demo.entity.BagType;
import com.example.demo.service.BagService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") 
public class BagController {

	@Autowired
	private BagService bagService;

	/**
	 * Create a new bag.
	 * 
	 * @param bag the bag to create
	 * @return the ResponseEntity with status 200 (OK) and with body of the new bag
	 */
	@PostMapping("/bag")
	public ResponseEntity<Bag> addBag(@RequestBody Bag bag) {
		Bag bag_added = bagService.createBag(bag);
		return ResponseEntity.ok(bag_added);

	}

	/**
	 * Get all bags.
	 */
	@GetMapping("/allBags")
	public List<Bag> readAllBags() {
		return bagService.getAllBags();
	}

	/**
	 * Get bag by id
	 * 
	 * @return the ResponseEntity with status 200 (OK) and with body of the bag, or
	 *         with status 404 (Not Found) if the bag does not exist
	 */
	@GetMapping("/bag/{id}")
	public ResponseEntity<Bag> getBagById(@PathVariable int id) {
		Optional<Bag> bag = bagService.getBagById(id);
		return bag.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	/**
	 * Update a bag by ID.
	 *
	 * @param id  the ID of the bag to update
	 * @param bag the updated bag
	 * @return the ResponseEntity with status 200 (OK) and with body of the updated
	 *         bag, or with status 404 (Not Found) if the bag does not exist
	 */
	@PutMapping("bag/{id}")
	public ResponseEntity<Bag> updateBag(@PathVariable int id, @RequestBody Bag bag) {
		Bag updatedBag = bagService.updateBagById(id, bag);
		return ResponseEntity.ok(updatedBag);
	}

	/**
	 * Delete a bag by ID.
	 *
	 * @param id the ID of the bag to delete
	 * @return the ResponseEntity with status 200 (OK) and with body of the message
	 *         "bag deleted successfully"
	 */
	@DeleteMapping("/bag/{id}")
	public ResponseEntity<String> deleteBag(@PathVariable int id) {
		bagService.deleteBagById(id);
		return ResponseEntity.ok("Bag deleted successfully");
	}

	/**
	 * Delete all items
	 * 
	 * @return the ResponseEntity with status 200 (OK) and with body of the message
	 *         "Product deleted successfully"
	 */
	@DeleteMapping("/bags")
	public ResponseEntity<String> deleteAllBags() {
		bagService.deleteAllBags();
		return ResponseEntity.ok("All bags deleted successfully");
	}
	
	/**
	 * Get bagType by bagType
	 * 
	 * @return the list of bag with the given bagType
	 */
	@GetMapping("/bag/type/{bagType}")
	public ResponseEntity<List<Bag>> getBagType(@PathVariable String bagType) {
        BagType type = BagType.valueOf(bagType.toUpperCase());
        List<Bag> bags = bagService.getBagType(type);
        return ResponseEntity.ok(bags);
	}


}
