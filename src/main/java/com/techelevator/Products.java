package com.techelevator;

import java.math.BigDecimal;

public abstract class Products {
	
	private String name;
	private BigDecimal price;

	public Products(String name, BigDecimal price){
		this.name = name;
		this.price = price;
	}
	
	protected abstract String getSound();

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	
}
