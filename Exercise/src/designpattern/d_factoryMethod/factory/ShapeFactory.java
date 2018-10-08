package designpattern.d_factoryMethod.factory;

import designpattern.d_factoryMethod.shape.Shape;

public abstract class ShapeFactory {
	
	public abstract Shape instantiation(String type);
	
	public Shape getShape(String type){
		Shape shape = instantiation(type);
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
