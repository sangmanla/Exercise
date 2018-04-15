package designpattern.b_TemplateMethod.shape;

public class Circle extends Shape {
	@Override
	void drawPoints() {
		System.out.println("No point for circle.");
	}

	@Override
	void drawLines() {
		System.out.println("One line for circle.");
	}
}
