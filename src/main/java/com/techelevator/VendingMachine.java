package com.techelevator;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class VendingMachine {

//Instance Variables
	private Map<String, Stack<Products>> inventory = new HashMap<String, Stack<Products>>();
	private BigDecimal currentBalance = new BigDecimal("0.00");
	private LogWriter logWriterObj = new LogWriter();
	
//Constructor
	
	public VendingMachine(Map<String, Stack<Products>> inventory){
		this.inventory = inventory;
	}
	

	public void displayInventory(){
		System.out.println(String.format("%-12s", "Quantity") + String.format("%-25s", "Product") + String.format("%-8s", "Price") + "Location");
		
		for(Entry<String, Stack<Products>> element : inventory.entrySet()){
			if(element.getValue().size() == 0){
				System.out.println(String.format("%-12s", "Sold Out") + String.format("%-25s", element.getValue().peek().getName()) 
		+ String.format("%-8s", element.getValue().peek().getPrice()) + element.getKey());
			} else {
				System.out.println(String.format("%-12s", element.getValue().size()) + String.format("%-25s", element.getValue().peek().getName()) 
				+ String.format("%-8s", element.getValue().peek().getPrice()) + element.getKey());
			}
		}
	}
	

	public void feedMoney(BigDecimal cash){
		logWriterObj.logWriterMeth(String.format("%-30s", "FEED MONEY: ") + String.format("%-10s", "$" + currentBalance) + "$" + (currentBalance.add(cash)));
		currentBalance = currentBalance.add(cash);
	}
	
	public Products selectProduct(String prodCode) throws Exception{
		if(!inventory.containsKey(prodCode)){
			System.out.println("Invalid item code.");
			throw new Exception();
		} else if (inventory.get(prodCode).size() == 0){
			System.out.println("Selection is sold out.");
			throw new Exception();
		}else if(currentBalance.compareTo(inventory.get(prodCode).peek().getPrice()) < 0){
			System.out.println("Please feed mo' money.");
			throw new Exception();
		}
		logWriterObj.logWriterMeth(String.format("%-30s", inventory.get(prodCode).peek().getName() + " " + prodCode) + 
					String.format("%-10s", "$" + currentBalance) + "$" + (currentBalance.subtract(inventory.get(prodCode).peek().getPrice())));
		currentBalance = currentBalance.subtract(inventory.get(prodCode).peek().getPrice());
		System.out.println("Purchase successful.");
		return inventory.get(prodCode).pop();
		}
		
		

	public void finishTransaction(){
		logWriterObj.logWriterMeth(String.format("%-30s", "GIVE CHANGE: ") + String.format("%-10s", "$" + currentBalance) + "$0.00");
		currentBalance = new BigDecimal("0.00");
	}
	
	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}
}
