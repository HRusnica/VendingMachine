package com.techelevator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.view.Menu;

public class VendingMachineCLITest {
	
	Menu menu;
	VendingMachineCLI sut;
	@Before
	public void setUp() throws Exception {
		sut = new VendingMachineCLI(menu, "./vendingmachinefake.csv");
		
		//It successfully died when given a bad file path.
	}
}
