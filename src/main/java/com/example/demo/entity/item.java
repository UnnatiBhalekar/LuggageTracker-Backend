package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int item_id;
	
	@Column(nullable = false)
	private String item_name;
	
	@Column(nullable = false)
	private float weight;
	
	@Column(nullable = false)
	private int quantity;

}
