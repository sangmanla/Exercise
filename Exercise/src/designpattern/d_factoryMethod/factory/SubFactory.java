package designpattern.d_factoryMethod.factory;

import designpattern.d_factoryMethod.shape.Circle;
import designpattern.d_factoryMethod.shape.Rectangle;
import designpattern.d_factoryMethod.shape.Shape;
import designpattern.d_factoryMethod.shape.Triangle;

public class SubFactory extends ShapeFactory {

	@Override
	public Shape instantiation(String type) {
		Shape instance = null;
		
		if("Circle".equals(type)) instance = new Circle();
		else if("Rectangle".equals(type)) instance = new Rectangle();
		else if("Triangle".equals(type)) instance = new Triangle();
		
		return instance;
	}

}