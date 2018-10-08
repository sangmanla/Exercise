package designpattern.decorator;

import designpattern.decorator.schema.BasicWarrior;
import designpattern.decorator.schema.CriticalWarrior;
import designpattern.decorator.schema.KindWarrior;
import designpattern.decorator.schema.Warrior;

public class DriverClass {

    public static void main(String[] args) {
	Warrior decoratedWarrior = new KindWarrior(new BasicWarrior());
	decoratedWarrior.shout();
	decoratedWarrior.fight();
	
	System.out.println("---------------------------------");
	
	Warrior decoratedWarrior2 = new CriticalWarrior(new BasicWarrior());
	decoratedWarrior2.shout();
	decoratedWarrior2.fight();
    }
}