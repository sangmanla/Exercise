package designpattern.d_factoryMethod.factory;

import designpattern.d_factoryMethod.shape.Shape;
import designpattern.d_factoryMethod.shape.Triangle;

public class SubFactory2 extends ShapeFactory {

	@Override
	public Shape instantiation(String type) {
		Shape instance = null;
		
		if("Triangle".equals(type)) instance = new Triangle();
		
		return instance;
	}
}