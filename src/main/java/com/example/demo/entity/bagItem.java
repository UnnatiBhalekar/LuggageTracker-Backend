package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class bagItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bag_item_id;
	
	private int bag_id;
	
	private int item_id;

	public bagItem(int bag_item_id, int bag_id, int item_id) {
		super();
		this.bag_item_id = bag_item_id;
		this.bag_id = bag_id;
		this.item_id = item_id;
	}

	public int getBag_item_id() {
		return bag_item_id;
	}

	public void setBag_item_id(int bag_item_id) {
		this.bag_item_id = bag_item_id;
	}

	public int getBag_id() {
		return bag_id;
	}

	public void setBag_id(int bag_id) {
		this.bag_id = bag_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	
	
	
}
