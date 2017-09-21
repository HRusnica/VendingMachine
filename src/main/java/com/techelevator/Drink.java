package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Products {
	
	public Drink(String name, BigDecimal price) {
		super(name, price);
	}

	@Override
		public String getSound() {
			return "Slurp Slurp, Yum!";

	}

}
