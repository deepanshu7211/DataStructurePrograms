package com.deep.design_patterns.decorator;

public class Milk extends Decorator {

	private Beverage beverage;

	public Milk(Beverage beverage) {
		super(beverage);
		this.beverage=beverage;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + " , Milk";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return beverage.cost() + 5;
	}

}
