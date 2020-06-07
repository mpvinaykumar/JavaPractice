package com.patterns.creational.factory;

public class ShapeFactoryVariant {

	public static Shape createShape(ShapeType inType) {
		Shape shape = null;
		switch (inType) {
		case SQUARE:
			shape = new Square();
			break;
		case RECTANGLE:
			shape = new Rectangle();
			break;

		}
		return shape;
	}

	public void provideInfo(ShapeType inType, int l, int b) {
		Shape shape = createShape(inType);
		shape.draw(l, b);
		shape.computeArea(l, b);
		shape.computePerimeter(l, b);
	}
}
