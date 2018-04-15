package designpattern.c_SimpleFactory.Shape;

public class Rectangle extends Shape {
	public void draw() {
		System.out.println("I am a Rectangle.");
	}

	@Override
	public void prepare() {
		System.out.println("Create Rectangle prepare.");
	}

	@Override
	public void later() {
		System.out.println("Create Rectangle later.");
	}
}