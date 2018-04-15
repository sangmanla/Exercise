package designpattern.b_TemplateMethod.shape;

public abstract class Shape {
	public final void draw(){
		System.out.println("--------------------");
		drawPoints();
		drawLines();
		System.out.println("--------------------");
	}
	
	abstract void drawPoints();
	abstract void drawLines();
}