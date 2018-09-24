package com.deep.design_patterns.decorator;

public class DecoratorMain {
	public static void main(String[] args) {
		Beverage beverage = new Latte();
		beverage = new Milk(beverage);
		beverage = new Choclate(beverage);
		System.out.println(beverage.getDescription());
		System.out.println(beverage.cost());
	}
}
