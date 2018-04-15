package designpattern.d_factoryMethod.shape;

public class Triangle extends Shape {
	public void draw() {
		System.out.println("I am a Triangle.");
	}

	@Override
	public void prepare() {
		System.out.println("Create Triangle prepare.");
	}

	@Override
	public void later() {
		System.out.println("Create Triangle later.");
	}
}