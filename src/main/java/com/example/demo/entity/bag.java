package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Bag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bag_id;

	@Column(nullable = false)
	private float maxCapacity;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bag")
	private List<BagItem> bagItem;

}
