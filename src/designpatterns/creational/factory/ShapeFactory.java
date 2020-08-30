package designpatterns.creational.factory;

public abstract class ShapeFactory {

	protected abstract Shape createShape(ShapeType inType) ;
	
	public void provideInfo(ShapeType inType,int l, int b){
		Shape shape = createShape(inType);
		shape.draw(l, b );
		shape.computeArea(l, b);
		shape.computePerimeter(l ,b);
	}
}
