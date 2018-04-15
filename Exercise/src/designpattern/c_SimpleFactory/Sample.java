package designpattern.c_SimpleFactory;

import designpattern.c_SimpleFactory.Shape.Circle;
import designpattern.c_SimpleFactory.Shape.Rectangle;
import designpattern.c_SimpleFactory.Shape.Triangle;

public class Sample {

	public static void main(String[] args) {
		ShapeFactory.getShape("Circle").draw();
		ShapeFactory.getShape("Triangle").draw();
		ShapeFactory.getShape("Rectangle").draw();
		
		ShapeFactory.getShape(Circle.class).draw();
		ShapeFactory.getShape(Triangle.class).draw();
		ShapeFactory.getShape(Rectangle.class).draw();
	}
}
