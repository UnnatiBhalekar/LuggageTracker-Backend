package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Bag;
import com.example.demo.entity.BagType;
import com.example.demo.repository.BagRepository;

@Service
public class BagService {

	@Autowired
	private BagRepository bagRepository;

	// create an bag
	public Bag createBag(Bag bag) {
		return bagRepository.save(bag);
	}

	// get all bag
	public List<Bag> getAllBags() {
		return bagRepository.findAll();

	}

	// get bag by id
	public Optional<Bag> getBagById(int bag_id) {
		return bagRepository.findById(bag_id);
	}

	// update bag by id
	public Bag updateBagById(int id, Bag updated_bag) {

		Optional<Bag> existing_bag = bagRepository.findById(id);
		if (existing_bag.isPresent()) {
			Bag bag = existing_bag.get();
			bag.setMaxCapacity(updated_bag.getMaxCapacity());
			return bagRepository.save(bag);
		} else {
			throw new RuntimeException("Bag not found");
		}

	}

	// delete bag by id
	public void deleteBagById(int bag_id) {
		bagRepository.deleteById(bag_id);

	}

	// delete all bags
	public void deleteAllBags() {
		bagRepository.deleteAll();
	}

	// get the bag type
	public List<Bag> getBagType(BagType bagType) {
		return bagRepository.findByBagType(bagType);
	}
}
