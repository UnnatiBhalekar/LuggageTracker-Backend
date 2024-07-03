package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class bag {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bag_id;
	
	private float maxCapacity;

	public bag(int bag_id, float maxCapacity) {
		super();
		this.bag_id = bag_id;
		this.maxCapacity = maxCapacity;
	}

	public int getBag_id() {
		return bag_id;
	}

	public void setBag_id(int bag_id) {
		this.bag_id = bag_id;
	}

	public float getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(float maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	
	
}
