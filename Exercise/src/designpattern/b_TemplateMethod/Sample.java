package designpattern.b_TemplateMethod;

import designpattern.b_TemplateMethod.shape.Circle;
import designpattern.b_TemplateMethod.shape.Rectangle;
import designpattern.b_TemplateMethod.shape.Triangle;

/**
 * Template Method Pattern.
 * Defines the skeleton of an algorithm in a method, deferring some steps to subclasses. 
 * Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithms structure.
 * 
 * �߻� Ŭ������ ����/Structure�� �����ϰ�, �̰� ����Ŭ�������� ������Ŵ.
 * ��, ��ü ������ ǥ��ȭ �� ���� �� ������ ���ӽ�Ŵ. 
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
