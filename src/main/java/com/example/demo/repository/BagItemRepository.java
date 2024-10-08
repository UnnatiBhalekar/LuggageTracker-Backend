package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Bag;
import com.example.demo.entity.BagItem;
import com.example.demo.entity.Item;

@Repository
public interface BagItemRepository extends JpaRepository<BagItem, Integer> {

	@Query("SELECT i.item_name, i.weight " + "FROM BagItem bi " + "JOIN bi.item i " + "WHERE bi.bag.bag_id = :bagId")
	List<Object[]> findItemsByBagId(@Param("bagId") int bagId);

	@Query("SELECT SUM(i.weight * i.quantity)" + "FROM BagItem bi " + "JOIN bi.item i "
			+ "WHERE bi.bag.bag_id = :bagId")
	Float findTotalWeightByBagId(@Param("bagId") int bagId);
	
	boolean existsByBagAndItem(Bag bag, Item item);
	
	@Query("SELECT bi FROM BagItem bi WHERE bi.bag.bag_id = :bagId AND bi.item.item_name = :itemName")
	Optional<BagItem> findBagIdAndItemName(@Param("bagId") int bagId, @Param("itemName") String itemName);


}
