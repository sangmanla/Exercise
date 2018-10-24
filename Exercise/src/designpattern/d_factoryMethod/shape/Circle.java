package designpattern.d_factoryMethod.shape;

public class Circle implements Shape {

	public void draw() {
		System.out.println("I am a circle.");
	}

	@Override
	public void prepare() {
		System.out.println("Create circle prepare.");
	}

	@Override
	public void later() {
		System.out.println("Create circle later.");
	}
	
}
