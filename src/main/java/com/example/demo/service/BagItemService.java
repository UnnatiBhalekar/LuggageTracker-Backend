package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BagItem;
import com.example.demo.entity.BagWeightAndSpaceDTO;
import com.example.DTO.BagItemDTO;
import com.example.DTO.ItemDTO;
import com.example.demo.entity.Bag;
import com.example.demo.entity.Item;
import com.example.demo.repository.BagItemRepository;
import com.example.demo.repository.BagRepository;
import com.example.demo.repository.ItemRepository;

@Service
public class BagItemService {

	@Autowired
	private BagItemRepository bagItemRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private BagRepository bagRepository;

	// adding item to bag
	public BagItemDTO addItemToBag(int bagId, int itemId) {
		Bag bag = bagRepository.findById(bagId).orElseThrow(() -> new RuntimeException("Bag not found"));
		Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));

		BagItem bagItem = new BagItem();
		bagItem.setBag(bag);
		bagItem.setItem(item);
		BagItem savedBagItem = bagItemRepository.save(bagItem);

		ItemDTO itemDTO = new ItemDTO(item.getItem_id(), item.getItem_name(), item.getWeight(), item.getQuantity());
		return new BagItemDTO(savedBagItem.getBag_item_id(), itemDTO);
	}

	// items present in each bag
	public List<Object[]> itemsinEachBag(int bagId) {
		return bagItemRepository.findItemsByBagId(bagId);

	}

	// finding the bag weight and space available
	public BagWeightAndSpaceDTO getWeightAndAvailableSpace(int bagId) {
		Bag bag = bagRepository.findById(bagId).orElseThrow(() -> new RuntimeException("Bag not found"));
		Float totalWeight = bagItemRepository.findTotalWeightByBagId(bagId);

		if (totalWeight == null) {
			totalWeight = 0.0f;
		}

		float availableSpace = bag.getMaxCapacity() - totalWeight;
		return new BagWeightAndSpaceDTO(totalWeight, availableSpace);
	}

}
