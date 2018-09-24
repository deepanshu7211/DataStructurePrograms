package com.deep.design_patterns.decorator;

public class Choclate extends Decorator {

	private Beverage beverage;

	public Choclate(Beverage beverage) {
		super(beverage);
		this.beverage = beverage;

		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + " ,Choclate ";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return beverage.cost() + 15;
	}

}
