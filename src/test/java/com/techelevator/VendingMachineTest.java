package com.techelevator;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
VendingMachine sut;
	@Before
	public void setUp() throws Exception {
		sut = new VendingMachine();
	}

	@After
	public void tearDown() throws Exception {
	}
// *********** These tests have to be performed with ProductStacker turned to public *****************
//	@Test
//	public void testFiveInNewStack() { 
//		String[] productInfoArray = new String[3];
//		productInfoArray[0] = "A1";
//		productInfoArray[1] = "bubbleGum";
//		productInfoArray[2] = "1.23";
//		Stack<Products> prods = VendingMachine.productStacker(productInfoArray);
//		assertEquals(5, prods.size());
//	}
//	
//	@Test
//	public void testProductStackerPrice() {
//		String[] productInfoArray = new String[3];
//		productInfoArray[0] = "A1";
//		productInfoArray[1] = "bubbleGum";
//		productInfoArray[2] = "1.23";
//		Stack<Products> prods = VendingMachine.productStacker(productInfoArray);
//		assertEquals(new BigDecimal(productInfoArray[2]), prods.peek().getPrice());
//	}
//	
//	@Test
//	public void testProductStackerName() {
//		String[] productInfoArray = new String[3];
//		productInfoArray[0] = "A1";
//		productInfoArray[1] = "bubbleGum";
//		productInfoArray[2] = "1.23";
//		Stack<Products> prods = VendingMachine.productStacker(productInfoArray);
//		assertEquals(productInfoArray[1], prods.peek().getName());
//	}


}
