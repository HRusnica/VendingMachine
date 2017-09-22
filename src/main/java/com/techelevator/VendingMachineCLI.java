package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_QUIT = "Quit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													   MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_QUIT };
	
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
															PURCHASE_MENU_OPTION_SELECT_PRODUCT,
															PURCHASE_MENU_OPTION_FINISH_TRANSACTION };
	
	private static final String FEED_MENU_OPTION_FEED_ONE_DOLLAR = "Insert $1";
	private static final String FEED_MENU_OPTION_FEED_TWO_DOLLARS = "Insert $2";
	private static final String FEED_MENU_OPTION_FEED_FIVE_DOLLARS = "Insert $5";
	private static final String FEED_MENU_OPTION_FEED_TEN_DOLLARS = "Insert $10";
	private static final String FEED_MENU_OPTION_GO_BACK = "Back to Previous Menu";
	private static final String[] FEED_MENU_OPTIONS = { FEED_MENU_OPTION_FEED_ONE_DOLLAR, FEED_MENU_OPTION_FEED_TWO_DOLLARS, 
															FEED_MENU_OPTION_FEED_FIVE_DOLLARS, FEED_MENU_OPTION_FEED_TEN_DOLLARS,
															FEED_MENU_OPTION_GO_BACK};
	private Menu menu;
	private String filePath = "./vendingmachine.csv";
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	public VendingMachineCLI(Menu menu, String filePath) {
		this.menu = menu;
		this.filePath = filePath;
		File file = new File(filePath);
		if(!file.exists()){
			System.out.println("The file path does not exist.");
			System.exit(1);
		}
	}
	
	public void run() {

		StockReader stockReaderObj = new StockReader();
		VendingMachine ourMachine = new VendingMachine(stockReaderObj.stockReaderMeth(filePath));
		while(true) {
			Customer customerObj = new Customer();
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				ourMachine.displayInventory();
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				
				while(true){
					System.out.println("Your current balance is: $" + ourMachine.getCurrentBalance() +".");
					String choice2 = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					
					if(choice2.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						while(true){
							System.out.println("Your current balance is: $" + ourMachine.getCurrentBalance() +".");
							String choice3 = (String)menu.getChoiceFromOptions(FEED_MENU_OPTIONS);
							
							if(choice3.equals(FEED_MENU_OPTION_FEED_ONE_DOLLAR)){
								ourMachine.feedMoney(new BigDecimal("1.00"));
							}
							else if(choice3.equals(FEED_MENU_OPTION_FEED_TWO_DOLLARS)){
								ourMachine.feedMoney(new BigDecimal("2.00"));
							}
							else if(choice3.equals(FEED_MENU_OPTION_FEED_FIVE_DOLLARS)){
								ourMachine.feedMoney(new BigDecimal("5.00"));
							}
							else if(choice3.equals(FEED_MENU_OPTION_FEED_TEN_DOLLARS)){
								ourMachine.feedMoney(new BigDecimal("10.00"));
							}
							else if (choice3.equals(FEED_MENU_OPTION_GO_BACK)){
								break;
							}
						}
					} 
					else if(choice2.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
						Scanner userInput = new Scanner(System.in);
						System.out.println("Please provide the code for the product you want. ");
						String prodCode = userInput.nextLine();
						try{
							customerObj.addToRecentlyPurchased(ourMachine.selectProduct(prodCode));
						}catch(Exception e){}
					} 
					else if(choice2.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)){
						Change changeObj = new Change();
						List<BigDecimal> changeList = changeObj.makeChange(ourMachine.getCurrentBalance());
						System.out.println("You recieve $" + ourMachine.getCurrentBalance() + " in " + changeList.get(0) + " quarter(s), "
								+ changeList.get(1) + " dime(s), and " + changeList.get(2) + " nickel(s)." );
						ourMachine.finishTransaction();
						customerObj.chewWithYoMouthClosedYouFilthyAnimal();
						break;
					}
				}
			}else if(choice.equals(MAIN_MENU_OPTION_QUIT)) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
