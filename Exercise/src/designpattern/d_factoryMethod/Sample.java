package designpattern.d_factoryMethod;

import designpattern.d_factoryMethod.factory.ShapeFactory;
import designpattern.d_factoryMethod.factory.SubFactory1;
import designpattern.d_factoryMethod.factory.SubFactory2;
import designpattern.d_factoryMethod.shape.Shape;

public class Sample {

	public static void main(String[] args) {
		ShapeFactory factory = new SubFactory1();
		Shape shape = factory.getShape("Circle");
		shape.draw();
		
		shape = factory.getShape("Rectangle");
		shape.draw();
		
		ShapeFactory factory2 = new SubFactory2();
		shape = factory2.getShape("Triangle");
		shape.draw();
	}
}
