package designpattern.d_factoryMethod.factory;

import designpattern.d_factoryMethod.shape.Circle;
import designpattern.d_factoryMethod.shape.Rectangle;
import designpattern.d_factoryMethod.shape.Shape;
import designpattern.d_factoryMethod.shape.Triangle;

public abstract class ShapeFactory {
	
	public abstract Shape instantiation(String type);
	
	public Shape getShape(String type){
		Shape shape = instantiation(type);
//		if("Circle".equals(type)) shape = new Circle();
//		else if("Triangle".equals(type)) shape = new Triangle();
//		else shape = new Rectangle();
		
		shape.prepare();
		shape.later();
		
		return shape;
	}
	
	public Shape getShape(Class cls){
		Shape shape = null;
		
		try {
			shape = (Shape)cls.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		shape.prepare();
		shape.later();
		
		return shape;
	}
}
