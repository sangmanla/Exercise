package designpattern.visitor;

import designpattern.visitor.element.House;
import designpattern.visitor.visitor.StrangeVisitor;
import designpattern.visitor.visitor.Visitor;

public class DriverClass {
    public static void main(String[] args) {
	House house = new House();
	System.out.println("----------------------------");
	house.accept(new Visitor());
	System.out.println("----------------------------");
	house.accept(new StrangeVisitor());
	System.out.println("----------------------------");
    }
}