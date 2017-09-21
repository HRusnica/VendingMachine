package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;

import com.techelevator.view.Menu;

public class VendingMachine {

	Map<String, Stack<Products>> inventory = (stockReader());
	BigDecimal currentBalance = new BigDecimal("0.00");
	List<Products> recentlyPurchased = new ArrayList<>();
	
	private static Map<String, Stack<Products>> stockReader(){
		Map<String, Stack<Products>> inventory = new HashMap<>();
		try (Scanner input = new Scanner(new File("./vendingmachine.csv"))){
			while (input.hasNextLine()){
				String[] productInfoArray = input.nextLine().split("\\|");
				inventory.put(productInfoArray[0], productStacker(productInfoArray));
			}
		}
			catch (FileNotFoundException e) {
			System.out.println("Cannot find the text file.");
			System.exit(1);
		}
		return inventory;
	}

	private static Stack<Products> productStacker(String[] productInfoArray){
		Stack<Products> productStack = new Stack<>();
		if(productInfoArray[0].startsWith("A")){
			for(int i = 0; i < 5; i++){
				productStack.push(new Chips(productInfoArray[1], new BigDecimal(productInfoArray[2])));
			}
		}else if(productInfoArray[0].startsWith("B")){
			for(int i = 0; i < 5; i++){
				productStack.push(new Candy(productInfoArray[1], new BigDecimal(productInfoArray[2])));
			}
		}else if(productInfoArray[0].startsWith("C")){
			for(int i = 0; i < 5; i++){
				productStack.push(new Drink(productInfoArray[1], new BigDecimal(productInfoArray[2])));
			}
		}else if(productInfoArray[0].startsWith("D")){
			for(int i = 0; i < 5; i++){
				productStack.push(new Gum(productInfoArray[1], new BigDecimal(productInfoArray[2])));
			}
		}
		return productStack;
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

	private void logWriter(String input){
		try (PrintWriter logPrintWriter = new PrintWriter(new FileOutputStream( new File("./Log.txt"), true))){
			Date timeStamp = new Date();
			logPrintWriter.println(timeStamp + "  " + input);	
		}catch (FileNotFoundException e) {
			System.out.println("The log file is not available");
			System.exit(2);
		}
	}

	

	public void  feedMoney(BigDecimal cash){
		logWriter(String.format("%-30s", "FEED MONEY: ") + String.format("%-10s", "$" + currentBalance) + "$" + (currentBalance.add(cash)));
		currentBalance = currentBalance.add(cash);
		System.out.print("Your current balance is: $" + currentBalance +".");

	}
	
	public void selectProduct(String prodCode){
		if(!inventory.containsKey(prodCode)){
			System.out.println("Invalid item code");
			return;
		} else if (inventory.get(prodCode).size() == 0){
			System.out.println("Selection is sold out.");
			return;
		}else if(currentBalance.compareTo(inventory.get(prodCode).peek().getPrice()) < 0){
			System.out.println("Please feed mo' money.");
			return;
		}else {
			logWriter(String.format("%-30s", inventory.get(prodCode).peek().getName() + " " + prodCode) + 
					String.format("%-10s", "$" + currentBalance) + "$" + (currentBalance.subtract(inventory.get(prodCode).peek().getPrice())));
			currentBalance = currentBalance.subtract(inventory.get(prodCode).peek().getPrice());
			recentlyPurchased.add(inventory.get(prodCode).pop());
			System.out.println("Purchase successful.");
			System.out.println("Your current balance is $" + currentBalance);
		}
		
		
	}
}
