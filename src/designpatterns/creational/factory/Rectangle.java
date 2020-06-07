package com.patterns.creational.factory;


public class Rectangle extends Shape {
	public Rectangle() {
		super(ShapeType.RECTANGLE);
	}

	@Override
	public void draw(int l, int b) {
		System.out.println("Drawing Shape: RECTANGLE.....");
	}
	public void computeArea(int l, int b){
		System.out.println("Computing area...");
		double area = l*b;
		System.out.println(area);
		
	}
	public  void computePerimeter(int l, int b){
		System.out.println("Computing Perimeter........");
		double perimeter = 2*(l+b);
		System.out.println(perimeter);

	}
}
