package com.deep.design_patterns.factory;

public class FactoryPattern {
	public static void main(String[] args) {
		Shape shape = new ShapeFactory().getShape("circle");
		shape.draw();
	}
}

class ShapeFactory {
	private Shape shape = null;

	public Shape getShape(String type) {
		if (type.equalsIgnoreCase("circle")) {
			shape = new Circle();
		}
		if (type.equalsIgnoreCase("square")) {
			shape = new Square();
		}

		return shape;

	}
}

class Circle implements Shape {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println(" Circle Draw method ");

	}

}

class Square implements Shape {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Square drwa method");

	}

}