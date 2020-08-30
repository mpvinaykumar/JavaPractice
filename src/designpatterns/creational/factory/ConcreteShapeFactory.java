package designpatterns.creational.factory;

public class ConcreteShapeFactory extends ShapeFactory {

	@Override
	protected Shape createShape(ShapeType inType) {
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

}
