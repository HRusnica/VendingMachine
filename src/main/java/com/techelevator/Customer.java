package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private List<Products> recentlyPurchased = new ArrayList<>();
	
	public void addToRecentlyPurchased(Products purchased){
		recentlyPurchased.add(purchased);
	}
	
	public void chewWithYoMouthClosedYouFilthyAnimal(){
		for(Products element: recentlyPurchased){
			System.out.println(element.getSound());
		}
		
	}
}
