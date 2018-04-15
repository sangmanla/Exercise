package designpattern.b_TemplateMethod.shape;

public class Rectangle extends Shape {

	@Override
	void drawPoints() {
		System.out.println("Draw four points.");
		
	}

	@Override
	void drawLines() {
		System.out.println("Draw four lines.");
	}
}