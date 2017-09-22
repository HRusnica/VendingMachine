package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class StockReader {
	
	public Map<String, Stack<Products>> stockReaderMeth(String filePath){
		Map<String, Stack<Products>> inventory = new HashMap<>();
		try (Scanner input = new Scanner(new File(filePath))){
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
}
