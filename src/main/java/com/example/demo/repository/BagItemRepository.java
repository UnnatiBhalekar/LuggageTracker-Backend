package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BagItem;

@Repository
public interface BagItemRepository extends JpaRepository<BagItem, Integer>{

}
