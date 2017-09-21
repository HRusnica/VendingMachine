package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													   MAIN_MENU_OPTION_PURCHASE };
	
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
															PURCHASE_MENU_OPTION_SELECT_PRODUCT,
															PURCHASE_MENU_OPTION_FINISH_TRANSACTION };
	private Menu menu;
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	public void run() {
		VendingMachine ourMachine = new VendingMachine();
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				ourMachine.displayInventory();
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				
				while(true){
					String choice2 = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					
					if(choice2.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						BigDecimal amountToAdd = menu.getDecimalFromUser("How many dollars would you like to feed into the machine (1, 2, 5 and 10 dollar bills only)? ");
						ourMachine.feedMoney(amountToAdd);
					} else if(choice2.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
						Scanner userInput = new Scanner(System.in);
						System.out.println("Please provide the code for the product you want. ");
						String prodCode = userInput.nextLine();
						ourMachine.selectProduct(prodCode);
					} else if(choice2.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)){
						//Finish Transaction
					}
				
				
				
				
				
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
