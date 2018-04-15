package designpattern.c_SimpleFactory;

import designpattern.c_SimpleFactory.Shape.Circle;
import designpattern.c_SimpleFactory.Shape.Rectangle;
import designpattern.c_SimpleFactory.Shape.Shape;
import designpattern.c_SimpleFactory.Shape.Triangle;

public class ShapeFactory {
	public static Shape getShape(String type){
		Shape shape = null;
		if("Circle".equals(type)) shape = new Circle();
		else if("Triangle".equals(type)) shape = new Triangle();
		else shape = new Rectangle();
		
		shape.prepare();
		shape.later();
		
		return shape;
	}
	
	public static Shape getShape(Class cls){
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
