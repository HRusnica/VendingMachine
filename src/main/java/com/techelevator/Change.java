package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Change {
	public List<BigDecimal> makeChange(BigDecimal currentBalance){
		List<BigDecimal> changeList = new ArrayList<>();
		changeList.addAll(Arrays.asList(currentBalance.divideAndRemainder(new BigDecimal(".25"))));
		changeList.addAll(Arrays.asList(changeList.get(1).divideAndRemainder(new BigDecimal(".10"))));
		changeList.remove(1);
		changeList.addAll(Arrays.asList(changeList.get(2).divide(new BigDecimal(".05"))));
		changeList.remove(2);
		
		return changeList;
	}
}
