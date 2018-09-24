package com.deep.design_patterns.decorator;

public abstract class Decorator implements Beverage {
	private Beverage beverage;

	public Decorator(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription();
	}

	public int cost() {
		return beverage.cost();
	}

}
