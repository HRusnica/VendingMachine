package com.techelevator;

import static org.junit.Assert.*;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
VendingMachine sut;

	@Before
	public void setUp() throws Exception {
		Stack<Products> sutStack = new Stack<Products>();
		sutStack.push(new Chips("Funyuns", new BigDecimal("1.00")));
		sutStack.push(new Chips("Funyuns", new BigDecimal("1.00")));
		sutStack.push(new Chips("Funyuns", new BigDecimal("1.00")));
		sutStack.push(new Chips("Funyuns", new BigDecimal("1.00")));
		sutStack.push(new Chips("Funyuns", new BigDecimal("1.00")));
		Map<String, Stack<Products>> sutMap = new HashMap<>();
		sutMap.put("A1",sutStack);
		sut = new VendingMachine(sutMap);
	}

	@Test
	public void testFeedMoney(){
		sut.feedMoney(new BigDecimal("100.00"));
		assertEquals(sut.getCurrentBalance(), new BigDecimal("100.00"));
		//feedMoney will only receive one of four values
	}
	
	@Test
	public void testSelectProductInvalidCode(){
		int i = 0;
		try{
			sut.selectProduct("B2");
		}catch(Exception e){
			i = 1;
		}
		assertEquals(1 , i);
	}

	@Test
	public void testSelectProductSoldOut(){
		int i = 0;
		sut.feedMoney(new BigDecimal("100.00"));
		for(int j = 0; j < 6; j++){
			try{
				sut.selectProduct("A1");
			}catch(Exception e){
				i = 1;
			}
		}
		assertEquals(1 , i);
	}	
	
	@Test
	public void testSelectProductNotEnoughMoney(){
		int i = 0;
		try{
			sut.selectProduct("A1");
		}catch(Exception e){
			i = 1;
		}
		assertEquals(1 , i);
	}
	
	@Test
	public void testFinishTransaction(){
		sut.feedMoney(new BigDecimal("1.00"));
		sut.finishTransaction();
		assertEquals(sut.getCurrentBalance(),new BigDecimal("0.00"));
	}
}
