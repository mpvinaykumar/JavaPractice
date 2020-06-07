package com.patterns.creational.factory;

public abstract class Shape {
	protected ShapeType shapeType;

	public Shape(ShapeType shapeType) {
		this.shapeType = shapeType;
	}
	
	
	public abstract void draw(int l, int b);
	public abstract void computeArea(int l, int b);
	public abstract void computePerimeter(int l, int b);

}
