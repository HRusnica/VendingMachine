package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChangeTest {

	Change sut = new Change();
	
	@Test
	public void testOneQuarter() {
		List<BigDecimal> sutList = new ArrayList<>();
		sutList.add(new BigDecimal("1"));
		sutList.add(new BigDecimal("0"));
		sutList.add(new BigDecimal("0"));
		assertEquals(sut.makeChange(new BigDecimal("0.25")).get(0), sutList.get(0));
		assertEquals(sut.makeChange(new BigDecimal("0.25")).get(1), sutList.get(1));
		assertEquals(sut.makeChange(new BigDecimal("0.25")).get(2), sutList.get(2));
	}
	
	@Test
	public void testOneDime() {
		List<BigDecimal> sutList = new ArrayList<>();
		sutList.add(new BigDecimal("0"));
		sutList.add(new BigDecimal("1"));
		sutList.add(new BigDecimal("0"));
		assertEquals(sut.makeChange(new BigDecimal("0.10")).get(1), sutList.get(1));
		assertEquals(sut.makeChange(new BigDecimal("0.10")).get(0), sutList.get(0));
		assertEquals(sut.makeChange(new BigDecimal("0.10")).get(2), sutList.get(2));
	}
	
	@Test
	public void testOneNickel() {
		List<BigDecimal> sutList = new ArrayList<>();
		sutList.add(new BigDecimal("0"));
		sutList.add(new BigDecimal("0"));
		sutList.add(new BigDecimal("1"));
		assertEquals(sut.makeChange(new BigDecimal("0.05")).get(0), sutList.get(0));
		assertEquals(sut.makeChange(new BigDecimal("0.05")).get(1), sutList.get(1));
		assertEquals(sut.makeChange(new BigDecimal("0.05")).get(2), sutList.get(2));
	}
	
	@Test
	public void testOneOfEachCoin() {
		List<BigDecimal> sutList = new ArrayList<>();
		sutList.add(new BigDecimal("1"));
		sutList.add(new BigDecimal("1"));
		sutList.add(new BigDecimal("1"));
		assertEquals(sut.makeChange(new BigDecimal("0.40")).get(0), sutList.get(0));
		assertEquals(sut.makeChange(new BigDecimal("0.40")).get(1), sutList.get(1));
		assertEquals(sut.makeChange(new BigDecimal("0.40")).get(2), sutList.get(2));
	}


}
