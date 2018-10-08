package designpattern.d_factoryMethod;

import designpattern.d_factoryMethod.factory.ShapeFactory;
import designpattern.d_factoryMethod.factory.SubFactory;
import designpattern.d_factoryMethod.shape.Shape;

public class Sample {

	public static void main(String[] args) {
		ShapeFactory factory = new SubFactory();
		Shape shape = factory.getShape("Circle");
		shape.draw();
		
		shape = factory.getShape("Rectangle");
		shape.draw();
		
		shape = factory.getShape("Triangle");
		shape.draw();
	}
}
