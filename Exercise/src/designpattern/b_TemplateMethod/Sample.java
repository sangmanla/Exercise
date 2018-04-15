package designpattern.b_TemplateMethod;

import designpattern.b_TemplateMethod.shape.Circle;
import designpattern.b_TemplateMethod.shape.Rectangle;
import designpattern.b_TemplateMethod.shape.Triangle;

/**
 * Template Method Pattern.
 * Defines the skeleton of an algorithm in a method, deferring some steps to subclasses. 
 * Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithms structure.
 * 
 * 추상 클래스에 로직/Structure를 정의하고, 이걸 서브클래스에서 구현시킴.
 * 즉, 전체 로직의 표준화 후 개별 상세 행위는 위임시킴. 
 * 
 * @author sam
 */
public class Sample {
	public static void main(String[] args) {
		new Circle().draw();
		new Triangle().draw();
		new Rectangle().draw();
	}
}
