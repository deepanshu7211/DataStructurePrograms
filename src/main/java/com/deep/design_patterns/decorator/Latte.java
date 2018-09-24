package com.deep.design_patterns.decorator;

public class Latte implements Beverage {

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Latte Coffee";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 10;
	}

}
