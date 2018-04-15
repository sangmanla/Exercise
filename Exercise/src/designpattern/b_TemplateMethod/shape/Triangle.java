package designpattern.b_TemplateMethod.shape;

public class Triangle extends Shape {

	@Override
	void drawPoints() {
		System.out.println("Draw three points.");
		
	}

	@Override
	void drawLines() {
		System.out.println("Draw three lines.");
	}
}