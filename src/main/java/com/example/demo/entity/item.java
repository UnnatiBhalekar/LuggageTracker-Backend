package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class item {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int item_id;
	
	private String item_name;
	
	private float weight;

	public item(int item_id, String item_name, float weight) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.weight = weight;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	
}
