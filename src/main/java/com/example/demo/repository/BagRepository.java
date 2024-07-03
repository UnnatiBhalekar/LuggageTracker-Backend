package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Bag;

@Repository
public interface BagRepository extends JpaRepository<Bag, Integer>{

}
