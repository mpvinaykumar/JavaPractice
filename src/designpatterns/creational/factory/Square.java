package designpatterns.creational.factory;

public class Square extends Shape {
	public Square() {
		super(ShapeType.SQUARE);
	}

	@Override
	public void draw(int l, int b) {
		System.out.println("Drawing Shape: SQUARE.....");
	}
	public void computeArea(int l, int b){
		System.out.println("Computing area...");
		double area = l*b;
		System.out.println(area);
		
	}
	public  void computePerimeter(int l, int b){
		System.out.println("Computing Perimeter........");
		double perimeter = 4*l;
		System.out.println(perimeter);

	}
}
