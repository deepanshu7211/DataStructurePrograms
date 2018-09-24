package com.deep.design_patterns.decorator;

public class Espresso implements Beverage {

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Espresso Coffee ";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 20;
	}

}
