package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StockReaderTest {

StockReader sut = new StockReader();
Map<String, Stack<Products>> sutMap = sut.stockReaderMeth("vendingmachinefake.csv");
	@Before

	/*
	 * Our testfile contains:
		A1|Potato Crisps|3.05
		B1|Moonpie|1.80
		C1|Cola|1.25
		D1|U-Chews|0.85
	 */

	@Test
	public void testContainsAllKeys() {
		 
		assertTrue(sutMap.containsKey("A1"));
		assertTrue(sutMap.containsKey("B1"));
		assertTrue(sutMap.containsKey("C1"));
		assertTrue(sutMap.containsKey("D1"));
	}
	
	@Test
	public void testStackSize() {
		 
		assertEquals(5, sutMap.get("A1").size());
	}

	@Test
	public void testFirstKeyName() {
		 
		assertEquals("Potato Crisps", sutMap.get("A1").peek().getName());
	}
	
	@Test
	public void testSecondKeyName() {
		 
		assertEquals("Moonpie", sutMap.get("B1").peek().getName());
	}
	
	@Test
	public void testThirdKeyName() {
		 
		assertEquals("Cola", sutMap.get("C1").peek().getName());
	}
	
	@Test
	public void testFourthKeyName() {
		 
		assertEquals("U-Chews", sutMap.get("D1").peek().getName());
	}
	
	@Test
	public void testFirstKeyPrice() {
		 
		assertEquals(new BigDecimal("3.05"), sutMap.get("A1").peek().getPrice());
	}
	
	@Test
	public void testSecondKeyPrice() {
		 
		assertEquals(new BigDecimal("1.80"), sutMap.get("B1").peek().getPrice());
	}
	
	@Test
	public void testThirdKeyPrice() {
		 
		assertEquals(new BigDecimal("1.25"), sutMap.get("C1").peek().getPrice());
	}
	
	@Test
	public void testFourthKeyPrice() {
		 
		assertEquals(new BigDecimal("0.85"), sutMap.get("D1").peek().getPrice());
	}
	
	@Test
	public void testFirstKeyClass() {
		 
		assertEquals(new Chips("unicorns", new BigDecimal("11.11")).getClass(), sutMap.get("A1").peek().getClass());
	}
	
	@Test
	public void testSecondKeyClass() {
		 
		assertEquals(new Candy("unicorns", new BigDecimal("11.11")).getClass(), sutMap.get("B1").peek().getClass());
	}
	
	@Test
	public void testThirdKeyClass() {
		 
		assertEquals(new Drink("unicorns", new BigDecimal("11.11")).getClass(), sutMap.get("C1").peek().getClass());
	}
	
	@Test
	public void testFourthKeyClass() {
		 
		assertEquals(new Gum("unicorns", new BigDecimal("11.11")).getClass(), sutMap.get("D1").peek().getClass());
	}

	
	
}
